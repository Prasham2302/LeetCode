class Solution {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a,b) -> a[0] - b[0]);
        int[][] dp = new int[2][events.length];
        Arrays.fill(dp[0],-1);
        Arrays.fill(dp[1],-1);
        // System.out.println(Arrays.deepToString(events));
        // System.out.println("1 "+ events[2][2]);
        return solve(events, dp, 0, 0);
    }
    public int solve(int[][] events, int[][] dp, int idx, int k) {
        // System.out.println("intial "+idx +" "+k +" "+Arrays.deepToString(dp));
        if (k == 2 || idx >= events.length) return 0;
        if (dp[k][idx] != -1) return dp[k][idx];
        int nextIdx = upperBound(events, idx);
        int includeVal = solve(events, dp, nextIdx, k+1);
        int include = events[idx][2] + includeVal;
        int exclude = solve(events, dp, idx+1, k);
        dp[k][idx] = Math.max(include, exclude);
        // System.out.println("include "+include +" exclude "+exclude +" "+includeVal +" "+events[idx][2] +" "+idx);
        // System.out.println("later "+idx +" "+k +" "+Arrays.deepToString(dp) +" upperbound "+nextIdx);
        return dp[k][idx];
    }
    public int upperBound(int[][] events, int idx) {
        int target = events[idx][1];
        int left = idx + 1;
        int right = events.length-1;
        int ans = events.length;
        while (left <= right) {
            // System.out.println("in UpperBound "+left +" "+right);
            int mid = (right + left) / 2;
            if (events[mid][0] > target) {
                right = mid-1;
                ans = mid;
            } else {
                left = mid+1;
            }
        }
        // System.out.println("in UpperBound "+idx +" "+ans);
        return ans;
    }
}