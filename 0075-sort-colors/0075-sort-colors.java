class Solution {
    public void sortColors(int[] nums) {
        // pass 0
        int zeroFromLeft = 0;
        int twoFromRight = nums.length-1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int t = nums[i];
                nums[i] = nums[zeroFromLeft];
                nums[zeroFromLeft] = t;
                zeroFromLeft++;
            } 
        }

        for (int i = nums.length-1; i >= 0; i--) {
            if (nums[i] == 2) {
                int t = nums[i];
                nums[i] = nums[twoFromRight];
                nums[twoFromRight] = t;
                twoFromRight--;
            }
        }
    }
}