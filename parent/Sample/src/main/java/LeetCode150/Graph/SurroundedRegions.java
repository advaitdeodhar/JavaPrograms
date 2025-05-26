package LeetCode150.Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class SurroundedRegions {

    public void solve(char[][] board) {

        int rows = board.length;
        int columns = board[0].length;


        boolean[][] visited = new boolean[rows][columns];

        for ( int i = 0 ; i < rows; i++ ) {
            for ( int j = 0 ; j < columns; j++ ) {
                if ( !visited[i][j] && board[i][j] == 'O' ) {
                    exploreIsland(board, visited, i, j);
                }
            }
        }
    }

    private void exploreIsland(char[][] grid, boolean[][] visited, int r, int c) {

        boolean isRegionOnEdge = false;

        int[] rn = {0, 0, -1, +1};
        int[] cn = {-1, 1, 0, 0};

        Queue<Integer> rq = new ArrayDeque<>();
        Queue<Integer> cq = new ArrayDeque<>();

        List<Integer> rl = new ArrayList<>();
        List<Integer> cl = new ArrayList<>();

        rq.add(r);
        cq.add(c);

        while ( ! rq.isEmpty() && ! cq.isEmpty() ) {

//            Queue<Integer> nrq = new ArrayDeque<>();
//            Queue<Integer> ncq = new ArrayDeque<>();


            int cr = rq.poll();
            int cc = cq.poll();

            rl.add(cr);
            cl.add(cc);



            for ( int i = 0 ; i < 4 ; i++ ) {
                if ( exploreLand(grid, visited, cr+rn[i], cc+cn[i], rq, cq) ) {
                    isRegionOnEdge = true;
                }
            }
        }

        if ( !isRegionOnEdge ) {
            for ( int i = 0 ; i < rl.size(); i++ ) {
                grid[rl.get(i)][cl.get(i)] = 'X';
            }
        }


    }


    private boolean exploreLand(char[][] grid, boolean[][] visited, int r, int c, Queue<Integer> rq, Queue<Integer> cq) {

        if ( r < 0 || c < 0 ) {
            return true;
        }

        if ( r > grid.length - 1|| c > grid[0].length - 1 ) {
            return true;
        }

        boolean isExplored = !visited[r][c] && grid[r][c] == 'O';

        if ( isExplored ) {
            rq.add(r);
            cq.add(c);
        }

        visited[r][c] = true;

        return false;

    }


}
