class Solution {

    public void setZeroes(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean firstCol = false;

        // Step 1: Use first row and first column as markers
        for(int i = 0; i < rows; i++) {

            if(matrix[i][0] == 0)
                firstCol = true;

            for(int j = 1; j < cols; j++) {

                if(matrix[i][j] == 0) {

                    matrix[i][0] = 0;
                    matrix[0][j] = 0;

                }

            }

        }

        // Step 2: Traverse backwards
        for(int i = rows - 1; i >= 0; i--) {

            for(int j = cols - 1; j >= 1; j--) {

                if(matrix[i][0] == 0 || matrix[0][j] == 0)

                    matrix[i][j] = 0;

            }

            if(firstCol)

                matrix[i][0] = 0;

        }

    }
}