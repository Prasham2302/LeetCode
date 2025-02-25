class Times implements Comparable<Times>{
    int time;
    int isEnd;
    int value;
    Times(int time, int isEnd, int value) {
        this.time = time;
        this.isEnd = isEnd;
        this.value = value;
    }
    @Override
    public int compareTo(Times other) {        
        if (this.time == other.time) {
            return this.isEnd - other.isEnd;
        }
        return this.time - other.time;
    }
    @Override
    public String toString() {
        return time + " " + isEnd + " " + value;
    }

}
class Solution {
    public int maxTwoEvents(int[][] events) {
        Times[] times = new Times[2 * events.length];
        int j = 0;
        for (int[] event : events) {
            times[j] = new Times(event[0], 1, event[2]);
            j++;
            times[j] = new Times(event[1]+1, 0, event[2]);
            j++;
        }
        Arrays.sort(times);
        // System.out.println(Arrays.toString(times));
        int ans = 0;
        int currMax = 0;
        for (int i = 0;i<times.length;i++) {
            Times time = times[i];
            if (time.isEnd == 0) {
                currMax = Math.max(currMax, time.value);
            }
            else {
                ans = Math.max(currMax + time.value, ans);
            }
            // System.out.println(time.toString() +" || "+currMax+" "+ans);
        }
        return ans;

    }
}