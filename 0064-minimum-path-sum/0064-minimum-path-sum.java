class Solution {
    public int pathSum(int[][] grid, int[][] dp, int m, int n) {
        if (m < 0 || n < 0) return Integer.MAX_VALUE;
        if (m == 0 && n == 0) return grid[m][n];

        if (dp[m][n] != -1) return dp[m][n];

        int l = pathSum(grid, dp, m-1, n);
        int t = pathSum(grid, dp, m, n-1);

        return dp[m][n] = grid[m][n] + Math.min(l, t);
    }
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i <= m; i++) Arrays.fill(dp[i], -1);
        return pathSum(grid, dp, m-1, n-1);
    }
}