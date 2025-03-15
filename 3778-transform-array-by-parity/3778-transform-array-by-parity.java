class Solution {
    public int[] transformArray(int[] nums) {
        int idx = 0;
        for (int i = 0;i<nums.length;i++) 
            if (nums[i] % 2 == 0) nums[idx++] = 0;
        while (idx < nums.length) nums[idx++] = 1;
        return nums;
    }
}