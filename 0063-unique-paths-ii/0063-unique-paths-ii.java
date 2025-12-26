class Solution {

    int paths(int[][] grid, int[][] dp, int i, int j) {

        if (i < 0 || j < 0) return 0;
        if (grid[i][j] == 1) return 0;
        if (i == 0 && j == 0) return 1;

        if (dp[i][j] != -1) return dp[i][j];

        int p = paths(grid, dp, i - 1, j) + paths(grid, dp, i, j - 1);
        return dp[i][j] = p;
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m+1][n+1];

        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], -1);
        }

        if (obstacleGrid[0][0] == 1) return 0;

        return paths(obstacleGrid, dp, m - 1, n - 1);
    }
}
