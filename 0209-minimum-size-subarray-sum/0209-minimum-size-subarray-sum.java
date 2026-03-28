class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0;
        int s = 0;
        int ans = Integer.MAX_VALUE;
        for (int r = 0; r < nums.length; r++) {
            s+=nums[r];

            // System.out.printf("sum=%d  nums[r]=%d nums[l]=%d\n", s, nums[r], nums[l]);

            while (s>=target) {
                ans = Math.min(ans, r - l + 1);
                s-=nums[l];
                l++;
            }
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}