import java.util.*;

class Solution {
    int[][] dp;

    public int solve(String t1, String t2, int n, int m, int[][] dp) {
        if (n < 0 || m < 0) return 0;

        if (dp[n][m] != -1) return dp[n][m];

        if (t1.charAt(n) == t2.charAt(m)) {
            dp[n][m] = 1 + solve(t1, t2, n - 1, m - 1, dp);
        } else {
            dp[n][m] = Math.max(
                solve(t1, t2, n - 1, m, dp),
                solve(t1, t2, n, m - 1, dp)
            );
        }

        return dp[n][m];
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(text1, text2, n - 1, m - 1, dp);
    }
}
