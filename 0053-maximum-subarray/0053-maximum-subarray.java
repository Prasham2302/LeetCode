class Solution {
    public int maxSubArray(int[] nums) {
        int maxSoFar = 0;
        int maxEndingHere = Integer.MIN_VALUE;
        for(int i = 0;i<nums.length;i++){
            maxSoFar += nums[i];
            maxEndingHere = Math.max(maxSoFar, maxEndingHere);
            if (maxSoFar < 0) {
                maxSoFar = 0;
            }
        }
        return maxEndingHere;
    }
}