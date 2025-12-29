// class Solution {
//     private static int[] memo;

//     public int climbStairs(int n) {
//         if (memo == null) {
//             memo = new int[1000];
//             Arrays.fill(memo, -1); 
//         }

//         if (n == 1 || n == 0) {
//             return 1;
//         }

//         if (memo[n] != -1) {
//             return memo[n];
//         }

//         int res = climbStairs(n-1) + climbStairs(n-2);
//         memo[n] = res;
        
//         return res;
//     }
// }



class Solution {
    private static int[] dp;
    public int climbStairs(int n) {
        if (dp == null) {
            dp = new int[1000];
            Arrays.fill(dp, -1);
        }

        if (n == 0 || n == 1) {
            return 1;
        }

        if (dp[n] != -1) return dp[n];

        return dp[n] = climbStairs(n - 1) + climbStairs(n - 2);
    }
}