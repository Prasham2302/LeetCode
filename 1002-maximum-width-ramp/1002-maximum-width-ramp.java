class Solution {
    public int maxWidthRamp(int[] nums) {
        Stack<Integer> decreasingStack = new Stack<>();
        decreasingStack.add(0);
        for (int i = 1;i<nums.length;i++) {
            if (nums[decreasingStack.peek()] > nums[i]){
                decreasingStack.push(i);
            }
        }
        int width = 0;
        for (int i = nums.length - 1;i>=0;i--) {
            if (decreasingStack.isEmpty()){
                return width;
            }
            if (nums[i] >= nums[decreasingStack.peek()]){
                // System.out.println(nums[i] +" "+nums[decreasingStack.peek()]);
                width = Math.max(width, i - decreasingStack.peek());
                decreasingStack.pop();
                i++;
            }
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