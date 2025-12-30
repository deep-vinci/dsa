class Solution {
    int[][] dp;
    public int solve(String s, int l, int r) {
        if (l > r) return 0;
        if (l == r) return 1;

        if (dp[r][l] != -1) return dp[r][l];

        if (s.charAt(l) == s.charAt(r)) {
            dp[r][l] = 2 + solve(s, l+1, r-1);
        } else {
            dp[r][l] = Math.max(solve(s, l, r-1), solve(s, l+1, r));
        }

        return dp[r][l];
    }

    public int longestPalindromeSubseq(String s) {
        int l = 0;
        int r = s.length()-1;
        if (r == 0) return 1;

        dp = new int[r+1][r+1];
        for (int i = 0; i < r+1; i++) Arrays.fill(dp[i], -1);
        return solve(s, l, r);
    }
}