package LeetCode150.Matrix;

class ValidSodoku {
    public boolean isValidSudoku(char[][] board) {


        int[][][] sections = {
                // Rows
                {{0,0},{0,1},{0,2},{0,3},{0,4},{0,5},{0,6},{0,7},{0,8}}, // Row 0
                {{1,0},{1,1},{1,2},{1,3},{1,4},{1,5},{1,6},{1,7},{1,8}}, // Row 1
                {{2,0},{2,1},{2,2},{2,3},{2,4},{2,5},{2,6},{2,7},{2,8}}, // Row 2
                {{3,0},{3,1},{3,2},{3,3},{3,4},{3,5},{3,6},{3,7},{3,8}}, // Row 3
                {{4,0},{4,1},{4,2},{4,3},{4,4},{4,5},{4,6},{4,7},{4,8}}, // Row 4
                {{5,0},{5,1},{5,2},{5,3},{5,4},{5,5},{5,6},{5,7},{5,8}}, // Row 5
                {{6,0},{6,1},{6,2},{6,3},{6,4},{6,5},{6,6},{6,7},{6,8}}, // Row 6
                {{7,0},{7,1},{7,2},{7,3},{7,4},{7,5},{7,6},{7,7},{7,8}}, // Row 7
                {{8,0},{8,1},{8,2},{8,3},{8,4},{8,5},{8,6},{8,7},{8,8}}, // Row 8

                // Columns
                {{0,0},{1,0},{2,0},{3,0},{4,0},{5,0},{6,0},{7,0},{8,0}}, // Col 0
                {{0,1},{1,1},{2,1},{3,1},{4,1},{5,1},{6,1},{7,1},{8,1}}, // Col 1
                {{0,2},{1,2},{2,2},{3,2},{4,2},{5,2},{6,2},{7,2},{8,2}}, // Col 2
                {{0,3},{1,3},{2,3},{3,3},{4,3},{5,3},{6,3},{7,3},{8,3}}, // Col 3
                {{0,4},{1,4},{2,4},{3,4},{4,4},{5,4},{6,4},{7,4},{8,4}}, // Col 4
                {{0,5},{1,5},{2,5},{3,5},{4,5},{5,5},{6,5},{7,5},{8,5}}, // Col 5
                {{0,6},{1,6},{2,6},{3,6},{4,6},{5,6},{6,6},{7,6},{8,6}}, // Col 6
                {{0,7},{1,7},{2,7},{3,7},{4,7},{5,7},{6,7},{7,7},{8,7}}, // Col 7
                {{0,8},{1,8},{2,8},{3,8},{4,8},{5,8},{6,8},{7,8},{8,8}}, // Col 8

                // 3x3 Subgrids
                {{0,0},{0,1},{0,2},{1,0},{1,1},{1,2},{2,0},{2,1},{2,2}}, // Subgrid 0
                {{0,3},{0,4},{0,5},{1,3},{1,4},{1,5},{2,3},{2,4},{2,5}}, // Subgrid 1
                {{0,6},{0,7},{0,8},{1,6},{1,7},{1,8},{2,6},{2,7},{2,8}}, // Subgrid 2
                {{3,0},{3,1},{3,2},{4,0},{4,1},{4,2},{5,0},{5,1},{5,2}}, // Subgrid 3
                {{3,3},{3,4},{3,5},{4,3},{4,4},{4,5},{5,3},{5,4},{5,5}}, // Subgrid 4
                {{3,6},{3,7},{3,8},{4,6},{4,7},{4,8},{5,6},{5,7},{5,8}}, // Subgrid 5
                {{6,0},{6,1},{6,2},{7,0},{7,1},{7,2},{8,0},{8,1},{8,2}}, // Subgrid 6
                {{6,3},{6,4},{6,5},{7,3},{7,4},{7,5},{8,3},{8,4},{8,5}}, // Subgrid 7
                {{6,6},{6,7},{6,8},{7,6},{7,7},{7,8},{8,6},{8,7},{8,8}}  // Subgrid 8
        };

        int ans = 0;
        int temp;
        int i ,j;

        for ( int s = 0 ; s < 27 ; s++ ) {
            ans = 0;

            for ( int p = 0 ; p < 9; p++ ) {
                i = sections[s][p][0];
                j = sections[s][p][1];
                if ( board[i][j] == '.' ) {
                    continue;
                }
                temp = ans | (1 << (board[i][j] - '0'));
                if ( ans == temp ) {
                    return false;
                }
                ans = temp;
            }
        }




//        for ( int i = 0 ; i < 9; i++ ) {
//            ans = 0;
//            for ( int j = 0; j < 9; j++ ) {
//                if ( board[i][j] == '.' ) {
//                    continue;
//                }
//                temp = ans ^ (1 << (board[i][j] - '0'));
//                if ( ans == temp ) {
//                    return false;
//                }
//                ans = temp;
//            }
//        }
//
//        for ( int j = 0 ; j < 9; j++ ) {
//            ans = 0;
//            for ( int i = 0; i < 9; i++ ) {
//                if ( board[i][j] == '.' ) {
//                    continue;
//                }
//                temp = ans | (1 << (board[i][j] - '0'));
//                if ( ans == temp ) {
//                    return false;
//                }
//                ans = temp;
//            }
//        }

        return true;

    }

    public static void main(String[] args) {
        ValidSodoku s = new ValidSodoku();
        char[][] board = {
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        System.out.println(s.isValidSudoku(board));
    }
}