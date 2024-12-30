class Solution {
    public int longestArithSeqLength(int[] nums) {
        int[][] dp = new int[nums.length][1002];

        int max = 0;
        for (int i = 1;i<nums.length;i++) {
            for (int j = 0;j<i;j++) {
                int diff = nums[i] - nums[j] + 500;
                dp[i][diff] = dp[j][diff] + 1;
                max = Math.max(max, dp[i][diff]);
                // System.out.println(i+" "+j+" "+max+" "+diff);
            }            
        }
        return max + 1;
    }
}