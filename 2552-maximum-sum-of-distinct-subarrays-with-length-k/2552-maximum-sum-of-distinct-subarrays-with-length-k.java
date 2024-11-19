class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long maxSum = 0;
        int left = 0, right = 0;
        HashMap<Integer, Integer> set = new HashMap<>();
        long currSum = 0;
        while (right < k && right < nums.length) {
            currSum += nums[right];
            set.put(nums[right], set.getOrDefault(nums[right],0)+1);
            right++;
        }
        while(right < nums.length) {
            if (set.size() == k) 
                maxSum = Math.max(maxSum, currSum);
            if (set.get(nums[left]) == 1) 
                set.remove(nums[left]);
            else 
                set.put(nums[left], set.get(nums[left])-1);
            currSum -= nums[left];
            left++;
            if (!set.containsKey(nums[right])) 
                set.put(nums[right], 1);
            else 
                set.put(nums[right], set.get(nums[right])+1);
            
            currSum += nums[right];
            right++;
        }
        if (set.size() == k) 
            maxSum = Math.max(maxSum, currSum);
        return maxSum;
    }
}