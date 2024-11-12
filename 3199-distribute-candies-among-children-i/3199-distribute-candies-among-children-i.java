class Solution {
    public int distributeCandies(int n, int limit) {
        if (limit * 3 < n) {
            return 0;
        }
        int res = 0;
        for (int i = Math.min(limit, n); i >= 0; i--) {
            int n2 = n - i;
            if (n2 > limit * 2) continue;
            int j = Math.min(limit, n2); 
            int k = Math.max(0, n2 - j);
            res += j - k + 1;
        }
        return res;
    }
}