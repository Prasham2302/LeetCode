class Solution {
    public int maxAscendingSum(int[] nums) {
        int max = nums[0];
        int curr = nums[0];
        for (int i = 1;i<nums.length;i++) {
            if (nums[i] <= nums[i-1]) {
                curr = 0;
            } 
            curr += nums[i];
            max = Math.max(curr, max);
        }
        return max;
    }
}