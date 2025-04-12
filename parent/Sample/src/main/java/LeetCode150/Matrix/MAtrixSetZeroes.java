package LeetCode150.Matrix;

import java.util.HashSet;
import java.util.Set;

class MAtrixSetZeroes {
    public void setZeroes(int[][] matrix) {

        Set<Integer> rows = new HashSet<>();
        Set<Integer> columns = new HashSet<>();

        for ( int i = 0; i < matrix.length; i++ ) {

            for ( int j = 0; j < matrix[0].length; j++ ) {

                if ( matrix[i][j] == 0) {
                    rows.add(i);
                    columns.add(j);
                }
            }
        }

        int rowCount = matrix.length;
        int colCount = matrix[0].length;

        for ( int i = 0; i < colCount; i++ ) {
            for ( Integer row : rows) {
                matrix[row][i] = 0;
            }
        }

        for ( int i = 0; i < rowCount; i++ ) {
            for ( Integer col : columns) {
                matrix[i][col] = 0;
            }
        }



    }
}
