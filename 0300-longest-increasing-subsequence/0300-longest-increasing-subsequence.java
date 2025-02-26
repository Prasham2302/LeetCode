class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] sorted = new int[nums.length];
        Arrays.fill(sorted, Integer.MIN_VALUE);
        sorted[0] = nums[0];
        int count = 1;
        for (int i = 1;i<nums.length;i++) {
            if (sorted[count-1] < nums[i]) {
                sorted[count] = nums[i];
                count++;
            } else {
                int replaceIdx = justGreater(sorted, count, nums[i]);
                // System.out.println("ReplaceIdx "+replaceIdx+" numsVal "+nums[i]);
                sorted[replaceIdx] = nums[i];
            }
            // System.out.println(Arrays.toString(sorted));
        }
        return count;
    }
    public int justGreater(int[] arr, int right, int target) {
        // System.out.println("In just Greater: "+Arrays.toString(arr) + " "+right +" "+target);
        int left = 0;
        right--;
        while (left <= right) {
            int mid = (left + right) / 2;
            // System.out.println(left +" "+mid+" "+right);
            if (arr[mid] < target) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return left;
    }
}