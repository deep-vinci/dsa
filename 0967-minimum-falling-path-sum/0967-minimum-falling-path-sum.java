class Solution {
    public int pathSum(int[][] grid, int[][] dp, int m, int n) {
        if (n < 0 || n >= grid[0].length) return (int)1e9; 
        
        if (m == grid.length - 1) return grid[m][n];

        if (dp[m][n] != Integer.MIN_VALUE) return dp[m][n];

        int leftDiag = pathSum(grid, dp, m + 1, n - 1);
        int straightDown = pathSum(grid, dp, m + 1, n);
        int rightDiag = pathSum(grid, dp, m + 1, n + 1);

        return dp[m][n] = grid[m][n] + Math.min(leftDiag, Math.min(straightDown, rightDiag));
    }

    public int minFallingPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) Arrays.fill(dp[i], Integer.MIN_VALUE);

        int minPath = Integer.MAX_VALUE;
        
        for (int j = 0; j < n; j++) {
            minPath = Math.min(minPath, pathSum(grid, dp, 0, j));
        }
        
        return minPath;
    }
}