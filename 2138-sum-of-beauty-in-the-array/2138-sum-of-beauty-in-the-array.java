class Solution {
    public int sumOfBeauties(int[] nums) {
        int n = nums.length;
        int sum = 0;

        int[] leftMax = new int[n];
        int[] rightMin = new int[n];

        leftMax[0] = nums[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], nums[i]);
        }

        rightMin[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], nums[i]);
        }

        for (int i = 1; i <= n - 2; i++) {
            if (leftMax[i - 1] < nums[i] && nums[i] < rightMin[i + 1]) {
                sum += 2;
            } else if (nums[i - 1] < nums[i] && nums[i] < nums[i + 1]) {
                sum += 1;
            }
        }

        return sum;
    }
}
