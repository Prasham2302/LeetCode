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
        int i = nums.length-1;
        while (i>=0) {
            if (decreasingStack.isEmpty()){
                return width;
            }
            if (nums[i] >= nums[decreasingStack.peek()]){
                width = Math.max(width, i - decreasingStack.peek());
                decreasingStack.pop();
            }
            else {
                i--;
            }
        }
        return width;
    }
}