class Solution {
    public int minOperations(int[] nums, int k) {
        int count = 0;
        for (int hour : nums) 
            count += hour < k ? 1 : 0;
        return count;
    }
}