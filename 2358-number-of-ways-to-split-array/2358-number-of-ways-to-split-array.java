class Solution {
    public int waysToSplitArray(int[] nums) {
        long[] prefSum = new long[nums.length];
        prefSum[0] = nums[0];
        for (int i = 1;i<nums.length;i++) {
            prefSum[i] = prefSum[i-1] + nums[i];
        }
        // System.out.println(Arrays.toString(prefSum));
        int count = 0;
        for (int i = 0;i<nums.length-1;i++) {
            long rightSum = prefSum[nums.length-1] - prefSum[i];
            // System.out.println(i +" "+rightSum +" "+prefSum[i]);
            if (rightSum <= prefSum[i]) {
                count++;
            }
        }
        return count;
    }
}