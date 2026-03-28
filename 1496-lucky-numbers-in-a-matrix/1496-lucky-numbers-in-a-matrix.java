class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[] minRow = new int[n];
        int[] maxCol = new int[m];

        for (int i = 0; i < n; i++) {
            int localMin = Integer.MAX_VALUE;
            for (int j = 0; j < m; j++) {
                localMin = Math.min(localMin, matrix[i][j]);
            }
            minRow[i] = localMin;
        }

        for (int j = 0; j < m; j++) {
            int localMax = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                localMax = Math.max(localMax, matrix[i][j]);
            }
            maxCol[j] = localMax;
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == minRow[i] && matrix[i][j] == maxCol[j]) {
                    ans.add(matrix[i][j]);
                }
            }
        }

        return ans;
    }
}
