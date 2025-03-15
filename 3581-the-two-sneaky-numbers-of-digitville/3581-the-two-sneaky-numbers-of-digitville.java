class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int[] ans = new int[2];
        int idx = 0;
        int len = nums.length - 2;
        for (int num : nums) {
            int absValue = Math.abs(num % len);
            if (nums[absValue] >= len) {
                ans[idx] = absValue;
                idx++;
            } else {
                nums[absValue] += len;
            }
        }
        return ans;
    }
}