package LeetCode150.Graph;

import java.util.ArrayDeque;
import java.util.Queue;

class ExploreIslands {
    public int numIslands(char[][] grid) {

        int rows = grid.length;
        int columns = grid[0].length;
        int ans = 0 ;


        boolean[][] visited = new boolean[rows][columns];

        for ( int i = 0 ; i < rows; i++ ) {
            for ( int j = 0 ; j < columns; j++ ) {
                if ( !visited[i][j] && grid[i][j] == '1' ) {
                    exploreIsland(grid, visited, i, j);
                    ans++;
                }
            }
        }

        return ans;
    }

    private void exploreIsland(char[][] grid, boolean[][] visited, int r, int c) {

        int[] rn = {0, 0, -1, +1};
        int[] cn = {-1, 1, 0, 0};

        Queue<Integer> rq = new ArrayDeque<>();
        Queue<Integer> cq = new ArrayDeque<>();

        rq.add(r);
        cq.add(c);

        while ( ! rq.isEmpty() && ! cq.isEmpty() ) {

            Queue<Integer> nrq = new ArrayDeque<>();
            Queue<Integer> ncq = new ArrayDeque<>();


            int cr = rq.poll();
            int cc = cq.poll();

            for ( int i = 0 ; i < 4 ; i++ ) {
                if ( unexploredLand(grid, visited, cr+rn[i], cc+cn[i]) ) {
                    rq.add(cr+rn[i]);
                    cq.add(cc+cn[i]);
                }
            }



        }


    }

    private boolean unexploredLand(char[][] grid, boolean[][] visited, int r, int c) {

        if ( r < 0 || c < 0 ) {
            return false;
        }

        if ( r > grid.length - 1|| c > grid[0].length - 1 ) {
            return false;
        }

        boolean retVal = !visited[r][c] && grid[r][c] == '1';
        visited[r][c] = true;

        return retVal;

    }


    public static void main(String[] args) {

        ExploreIslands s = new ExploreIslands();

        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println(s.numIslands(grid));
    }
}
