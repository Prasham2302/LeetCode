class Solution {
    public int[] sumZero(int n) {
        if (n == 1) 
            return new int[]{0};
        if (n == 2) 
            return new int[]{-1, 1};
        int sum = (n * (n-1)) / 2;
        int[] ans = new int[n];
        for (int i = 1;i<n;i++) {
            ans[i] = i;
        }
        ans[0] = -1 * sum;
        return ans;
    }
}