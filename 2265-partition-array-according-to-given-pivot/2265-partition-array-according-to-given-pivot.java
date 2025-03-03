class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] ans = new int[nums.length];
        int left = 0, right = nums.length - 1;
        for (int i = 0, j = nums.length - 1; i < nums.length && j >= 0; i++, j--) {
            if (nums[i] < pivot) {
                ans[left++] = nums[i];
            } 
            if(nums[j] > pivot) {
                ans[right--] = nums[j];
            }
            // System.out.println(Arrays.toString(ans));
        }
        while (left <= right) {
            ans[left++] = pivot;
        }
        return ans;
    }
}