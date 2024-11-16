class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        Arrays.fill(result, -1);
        int score = 1;
        for (int i = 0;i<nums.length;i++) {
            if (i > 0 && nums[i-1] + 1 == nums[i]) 
                score++;
            else 
                score = 0;
            if (score >= k - 1)
                result[i - k + 1] = nums[i];
        }
        return result;
    }
}