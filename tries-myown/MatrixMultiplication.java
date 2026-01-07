public class MatrixMultiplication {
    public static void main(String[] args) {
        // Define two 2x2 matrices
        int[][] A = {
            {1, 2},
            {3, 4}
        };

        int[][] B = {
            {5, 6},
            {7, 8}
        };

        // Create result matrix of same size (2x2)
        int[][] result = new int[2][2];

        // Matrix multiplication logic: result[i][j] = A[i][0]*B[0][j] + A[i][1]*B[1][j]
        for (int i = 0; i < 2; i++) {              // rows of A
            for (int j = 0; j < 2; j++) {          // columns of B
                result[i][j] = 0;
                for (int k = 0; k < 2; k++) {      // columns of A / rows of B
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        // Print the result
        System.out.println("Result of matrix multiplication:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
