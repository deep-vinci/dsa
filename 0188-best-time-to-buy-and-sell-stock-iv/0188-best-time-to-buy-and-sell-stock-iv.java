// import java.util.Arrays;

// class Solution {

//     int[] prices;
//     int n;
//     int kl = 0;
//     int k;
//     int[][][] dp;

//     public int maxProfit(int k, int[] prices) {
//         this.prices = prices;
//         this.n = prices.length;

//         dp = new int[n][2][k+1];
//         for (int i = 0; i < n; i++) {
//             for (int h = 0; h < 2; h++) {
//                 Arrays.fill(dp[i][h], -1);
//             }
//         }
//         k = k;

//         return solve(0, 0, 0);
//     }

//     private int solve(int i, int holding, int kl) {

//         if (i == n || kl == k) {
//             return 0;
//         }
//         // if (kl == k) return 0;

//         if (dp[i][holding][kl] != -1) {
//             return dp[i][holding][kl];
//         }

//         int ans;

//         if (holding == 0) {
//             int skip = solve(i + 1, 0, kl);
//             int buy  = -prices[i] + solve(i + 1, 1, kl);
//             ans = Math.max(skip, buy);
//         }
//         else {
//             int skip = solve(i + 1, 1, kl);
//             int sell = prices[i] + solve(i + 1, 0, kl + 1);
//             ans = Math.max(skip, sell);
//         }

//         dp[i][holding][kl] = ans;
//         return ans;
//     }
// }


// class Solution {

//     int[] prices;
//     int n;
//     int[][][] dp;

//     public int maxProfit(int k, int[] prices) {
//         this.prices = prices;
//         this.n = prices.length;

//         dp = new int[n][2][k+1];
//         for (int i = 0; i < n; i++) {
//             for (int h = 0; h < 2; h++) {
//                 Arrays.fill(dp[i][h], -1);
//             }
//         }

//         return solve(0, 0, 0, k);
//     }

//     private int solve(int i, int holding, int t, int k) {

//         if (i == n || t == k) return 0;

//         if (dp[i][holding][t] != -1)
//             return dp[i][holding][t];

//         int ans;

//         if (holding == 0) {
//             int skip = solve(i + 1, 0, t, k);
//             int buy  = -prices[i] + solve(i + 1, 1, t, k);
//             ans = Math.max(skip, buy);
//         } else {
//             int skip = solve(i + 1, 1, t, k);
//             int sell = prices[i] + solve(i + 1, 0, t + 1, k);
//             ans = Math.max(skip, sell);
//         }

//         return dp[i][holding][t] = ans;
//     }
// }



class Solution {

    int[] prices;
    int n;
    int[][][] dp;

    public int maxProfit(int k, int[] prices) {
        this.prices = prices;
        this.n = prices.length;

        dp = new int[n][2][k+1];
        for (int i = 0; i < n; i++) {
            for (int h = 0; h < 2; h++) {
                Arrays.fill(dp[i][h], -1);
            }
        }

        return solve(0, 0, k);
    }

    private int solve(int i, int holding, int k) {

        if (i == n || k == 0) return 0;

        if (dp[i][holding][k] != -1)
            return dp[i][holding][k];

        int ans;

        if (holding == 0) {
            int skip = solve(i + 1, 0, k);
            int buy  = -prices[i] + solve(i + 1, 1, k);
            ans = Math.max(skip, buy);
        } else {
            int skip = solve(i + 1, 1, k);
            int sell = prices[i] + solve(i + 1, 0, k - 1);
            ans = Math.max(skip, sell);
        }

        return dp[i][holding][k] = ans;
    }
}
