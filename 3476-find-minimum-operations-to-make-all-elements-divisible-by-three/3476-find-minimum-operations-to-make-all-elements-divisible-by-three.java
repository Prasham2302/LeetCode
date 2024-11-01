class Solution {
    public int minimumOperations(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num % 3 == 2 ? 1 : num % 3;
        }
        return sum;
    }
}