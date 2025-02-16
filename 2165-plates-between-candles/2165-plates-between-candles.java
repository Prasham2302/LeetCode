class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int[] prefixSum = new int[s.length()];
        int[] candles = new int[s.length()];
        prefixSum[0] = s.charAt(0) == '|' ? 1 : 0;
        candles[0] = s.charAt(0) == '*' ? 1 : 0;
        for (int i = 1;i<prefixSum.length;i++) {
            if (s.charAt(i) == '|') {
                prefixSum[i]++;
            }
            prefixSum[i] += prefixSum[i-1];
            if (s.charAt(i) == '*') {
                candles[i]++;
            }
            candles[i] += candles[i-1];
        }
        int[] ans = new int[queries.length];
        int index = 0;
        for (int[] query : queries) {
            int left = query[0];
            int right = query[1];
            if (prefixSum[left] == prefixSum[right]) {
                ans[index] = 0;
                index++;
                continue;
            }
            int leftBound = left;
            if (s.charAt(leftBound) != '|') {
                leftBound = firstOccurrence(prefixSum, left, right+1, prefixSum[left]+1);
            }
            int rightBound = right;
            if (s.charAt(rightBound) != '|') {
                rightBound = firstOccurrence(prefixSum, left, right+1, prefixSum[right]);
            }
            ans[index] = candles[rightBound] - candles[leftBound];
            index++;
        }
        return ans;
    }
    public int firstOccurrence(int[] arr, int left, int right, int key) {
        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == key) {
                result = mid; 
                right = mid - 1;
            } else if (arr[mid] < key) {
                left = mid + 1; 
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}