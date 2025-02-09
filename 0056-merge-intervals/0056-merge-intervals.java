class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        List<int[]> mergedIntervals = new ArrayList<>();
        int index = 0;
        int[] curr = intervals[index];
        index++;
        while(index < intervals.length) {
            int[] next = intervals[index];
            if (curr[1] >= next[0]) {
                curr[1] = Math.max(curr[1], next[1]);
            } else {
                mergedIntervals.add(curr);
                curr = next;
            }
            index++;
        }
        mergedIntervals.add(curr);
        index=0;
        int[][] ans = new int[mergedIntervals.size()][2];
        for (int[] interval: mergedIntervals) {
            ans[index] = interval;
            index++;
        }
        return ans;
    }
}