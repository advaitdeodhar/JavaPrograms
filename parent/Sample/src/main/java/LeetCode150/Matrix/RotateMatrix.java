package LeetCode150.Matrix;

class RotateMatrix {
    public void rotate(int[][] matrix) {

        int size = matrix.length;
        int rowHalf = (size - 1)/ 2 ;
        int half =  (size  / 2) - 1;
        int v1, v2, v3,v4;
        for ( int i = 0 ; i <= rowHalf; i++ ) {

            for ( int j = 0 ; j <= half ; j++ ) {

                v1 = matrix[i][j];
                v2 = matrix[j][size - i - 1];
                v3 = matrix[size - i - 1][size - j -1];
                v4 = matrix[size - j - 1][i];


                matrix[i][j] = v4;
                matrix[j][size - i - 1] = v1;
                matrix[size - i - 1][size - j -1] = v2;
                matrix[size - j - 1][i] = v3;

            }

        }



    }

    public static void main(String[] args) {
        //int[][] data = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        int[][] data = {{1,2,3},{4,5,6},{7,8,9}};
        RotateMatrix s = new RotateMatrix();
        s.rotate(data);

        for (int i = 0; i < data.length; i++) {  // Loop through rows
            for (int j = 0; j < data[i].length; j++) {  // Loop through columns
                System.out.print(data[i][j] + " ");
            }
            System.out.println();  // New line after each row
        }

    }
}
