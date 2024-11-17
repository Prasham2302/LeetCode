class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        while(right < nums.length){
            // System.out.println(sum +" "+left+" "+right);
            sum += nums[right];
            right++;
            while (sum >= target && left < right){
                // System.out.println("inside loop: "+sum +" "+left+" "+right);
                ans = Math.min(right - left, ans);
                sum -= nums[left];
                left++;
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}