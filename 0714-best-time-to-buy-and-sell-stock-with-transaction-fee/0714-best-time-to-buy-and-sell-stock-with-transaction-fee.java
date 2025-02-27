class Solution {
    public int maxProfit(int[] prices, int fee) {
        int[][] dp =new int[2][prices.length];
        Arrays.fill(dp[0], -1);
        Arrays.fill(dp[1], -1);
        return helper(prices, 0, 0,dp, fee);
    }
    public int helper(int[] prices, int choice, int index, int[][] dp, int fee) {
        if (index >= prices.length) {
            return 0;
        }
        if (dp[choice][index] != -1) return dp[choice][index];
        if (choice == 0) {
            // Ready to buy
            int skip = helper(prices, 0, index + 1, dp, fee);
            int pick = helper(prices, 1, index + 1, dp, fee) - prices[index];
            dp[choice][index] = Math.max(skip, pick);
        } else {
            // Ready to sell
            int skip = helper(prices, 1, index + 1, dp, fee);
            int sell = helper(prices, 0, index + 1, dp, fee) + prices[index] - fee;
            dp[choice][index] = Math.max(skip, sell);
        }
        return dp[choice][index];
    }
}