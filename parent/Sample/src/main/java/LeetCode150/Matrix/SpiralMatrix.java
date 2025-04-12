package LeetCode150.Matrix;

import java.util.ArrayList;
import java.util.List;

class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int minRow = 0;
        int maxRow = matrix.length - 1;

        int minCol = 0;
        int maxCol = matrix[0].length - 1;

        while (minCol <= maxCol && minRow <= maxRow) {

            moveRight(matrix, ans, minRow, minCol, maxCol);
            minRow++;

            if (minRow <= maxRow) {
                moveDown(matrix, ans, maxCol, minRow, maxRow);
                maxCol--;
            }

            if ( minCol <= maxCol && minRow <= maxRow ) {
                moveLeft(matrix, ans, maxRow, maxCol, minCol);
                maxRow--;
            }

            if (minCol <= maxCol && minRow <= maxRow) {


                moveUp(matrix, ans, minCol, maxRow, minRow);
                minCol++;
            }
        }
        return ans;
    }

    private void moveUp(int[][] matrix, List<Integer> ans, int minCol, int maxRow, int minRow) {
        for ( int i = maxRow; i >= minRow; i-- ) {
            ans.add(matrix[i][minCol]);
        }
    }

    private void moveLeft(int[][] matrix, List<Integer> ans, int maxRow, int maxCol, int minCol) {
        for ( int i = maxCol; i >= minCol; i-- ) {
            ans.add(matrix[maxRow][i]);
        }
    }

    private void moveDown(int[][] matrix, List<Integer> ans, int maxCol, int minRow, int maxRow) {
        for ( int i = minRow; i <= maxRow; i++ ) {
            ans.add(matrix[i][maxCol]);
        }
    }

    private void moveRight(int[][] matrix, List<Integer> ans, int minRow, int minCol, int maxCol) {

        for ( int i = minCol; i <= maxCol; i++ ) {
            ans.add(matrix[minRow][i]);
        }
    }

    public static void main(String[] args) {
        SpiralMatrix s = new SpiralMatrix();
        int[][] data = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(s.spiralOrder(data));
    }
}
