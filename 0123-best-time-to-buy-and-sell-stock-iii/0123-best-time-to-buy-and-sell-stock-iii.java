class Solution {
    int prices[];
    int dp[][][];

    public int solve(int i, int holding, int k) {
        if(i == prices.length) return 0;
        if (k == 2) return 0;
        if (dp[i][holding][k] != -1) return dp[i][holding][k];
        
        int res = 0;
        if (holding == 0) {
            int skip = solve(i + 1, 0, k);
            int buy = -prices[i] + solve(i + 1, 1, k);
            res = Math.max(skip, buy);
        } else if (holding == 1) {
            int skip = solve(i + 1, 1, k);
            int sell = prices[i] + solve(i + 1, 0, k + 1); 
            res = Math.max(skip, sell);
        }
        return dp[i][holding][k] = res;
    }

    public int maxProfit(int[] prices) {
        this.prices = prices;

        dp = new int[prices.length][2][3];
        for (int i = 0; i < prices.length; i++) {
            for (int h = 0; h < 2; h++) {
                Arrays.fill(dp[i][h], -1);
            }
        }
        return solve(0, 0, 0);
    }
}