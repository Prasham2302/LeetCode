class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return helper(nums, (long)upper) - helper(nums, (long)lower-1);
    }
    public long helper(int[] nums, long target){
        int l = 0;
        int r = nums.length-1;
        long count = 0;
        while(l < r){
            long sum = nums[l] + nums[r];
            if(sum <= target){
                count += r - l;
                l++;
            }
            else{
                r--;
            }
        }
        return count;
    }
}