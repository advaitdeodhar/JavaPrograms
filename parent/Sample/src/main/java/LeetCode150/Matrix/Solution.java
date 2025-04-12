package LeetCode150.Matrix;

class Solution {
    public void gameOfLife(int[][] board) {

        int rowCount = board.length;
        int colCount = board[0].length;

        int[][] backup = new int[rowCount+2][colCount+2];
        int a,b;
        for ( int i = 0 ; i < rowCount; i++ ) {
            for ( int j = 0 ; j < colCount; j++ ) {
                if ( board[i][j] == 1 ) {
                    a = i + 1;
                    b = j +1;

                    backup[a-1][b-1]++;
                    backup[a-1][b]++;
                    backup[a-1][b+1]++;
                    backup[a][b-1]++;
                    backup[a][b+1]++;
                    backup[a+1][b-1]++;
                    backup[a+1][b]++;
                    backup[a+1][b+1]++;


                }
            }
        }

        for ( int i = 0 ; i < rowCount; i++ ) {
            for (int j = 0; j < colCount; j++) {
                a = i + 1;
                b = j + 1;

                if ( board[i][j] == 1 ) {
                    if ( backup[a][b] < 2 || backup[a][b] > 3 ) {
                        board[i][j] = 0;
                    }
                } else {
                    if ( backup[a][b] == 3 ) {
                        board[i][j] = 1;
                    }
                }

            }
        }



    }
}
