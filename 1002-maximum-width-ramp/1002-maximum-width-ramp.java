class Solution {
    public int maxWidthRamp(int[] nums) {
        ArrayList<Integer> decreasingStack = new ArrayList<>();
        decreasingStack.add(0);
        for (int i = 1;i<nums.length;i++) {
            int peek = nums[decreasingStack.get(decreasingStack.size() - 1)];
            if (peek > nums[i]){
                decreasingStack.add(i);
            }
        }
        int width = 0;
        for (int i = nums.length - 1;i>=0;i--) {
            int idx = binarySearch(decreasingStack, nums[i], nums);
            if (idx == -1){
                continue;
            }
            width = Math.max(width, i - idx);
        }
        return width;
    }
    public int binarySearch(ArrayList<Integer> array, int target, int[] nums){
        int left = 0, right = array.size()-1;
        int ans = -1;
        
        // System.out.println("Array: "+array+" "+target);
        while (left <= right) {
            int mid = (left + right) / 2;
            int midValue = nums[array.get(mid)];
            // System.out.println(left +" "+right+" "+midValue);
            if (midValue <= target) {
                ans = array.get(mid);
                right = mid-1;
            }
            else{
                left = mid+1;
            }
            // System.out.println("ANS: "+ans);
        }
        return ans;
    }
}