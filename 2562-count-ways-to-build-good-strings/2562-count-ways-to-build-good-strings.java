class Solution {
    int mod = (int) Math.pow(10, 9) + 7;
    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[high+1];
        Arrays.fill(dp, -1);
        int sum = 0;
        dp[0] = 1;
        for (int i = low;i<=high;i++) {
            sum += solve(dp, i, zero, one);
            sum %= mod;
        }
        return sum;
    }
    public int solve(int[] dp, int idx, int sub1, int sub2) {
        if (idx < 0) {
            return 0;
        }
        if (dp[idx] != -1) {
            return dp[idx];
        }
        dp[idx] = (solve(dp, idx-sub1, sub1, sub2) + solve(dp, idx-sub2, sub1, sub2)) % mod;
        return dp[idx];
    }
}