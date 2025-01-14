class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int length = A.length;
        for (int i=0;i<length;i++) {
            map.putIfAbsent(A[i],i);
        }
        int[] ans = new int[length];
        for (int i = 0;i<length;i++) {
            if (map.get(B[i]) <= i) {
                ans[i]++;
            } else {
                ans[map.get(B[i])]++;
            }
            if (i > 0) {
                ans[i] += ans[i-1];
            }
        }
        return ans;
    }
}