class Solution {
    public int[][] transpose(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int arr[][] = new int[c][r];
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                arr[i][j] = matrix[j][i];
            }
        }

        return arr;
    }
}