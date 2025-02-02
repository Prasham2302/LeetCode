class Solution {
    public boolean check(int[] nums) {
        boolean flag = false;
        for (int i  = 1;i<nums.length;i++) {
            if (nums[i] < nums[i-1]) {
                if (!flag) {
                    flag = true;
                } else {
                    // System.out.println(i);
                    return false;
                }
            }
            if (flag) {
                if (nums[i] > nums[0]) {
                    // System.out.println(i);
                    return false;
                }
            }
        }
        return true;
    }
}