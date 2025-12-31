import java.util.Arrays;

class Solution {

    int[] prices;
    int n;
    int[][] dp;

    public int maxProfit(int[] prices) {
        this.prices = prices;
        this.n = prices.length;

        dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(0, 0);
    }

    private int solve(int i, int holding) {

        if (i == n) {
            return 0;
        }

        if (dp[i][holding] != -1) {
            return dp[i][holding];
        }

        int ans;

        if (holding == 0) {
            int skip = solve(i + 1, 0);
            int buy  = -prices[i] + solve(i + 1, 1);
            ans = Math.max(skip, buy);
        }
        else {
            int skip = solve(i + 1, 1);
            int sell = prices[i];
            ans = Math.max(skip, sell);
        }

        dp[i][holding] = ans;
        return ans;
    }
}

