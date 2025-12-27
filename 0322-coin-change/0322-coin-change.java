class Solution {
    int[] dp;
    public int solve(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;

        if (dp[amount] != -2) return dp[amount];
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < coins.length; i++) {
            int res = solve(coins, amount - coins[i]);

            if (res != -1) {
                min = Math.min(min, res);
            }
        }

        // if (min == Integer.MAX_VALUE) return -1;
        dp[amount] = (min == Integer.MAX_VALUE) ? -1 : 1 + min;
        // return 1 + min;
        return dp[amount];
    }

    public int coinChange(int[] coins, int amount) {
        // int[] dp = new int[];
        dp = new int[amount + 1];
        Arrays.fill(dp, -2); 
        return solve(coins, amount);
    }
}
