class Solution {
    public long countCompleteDayPairs(int[] hours) {
        long[] freq = new long[24];
        for (int hour:hours){
            freq[hour % 24]++;
        }
        long count = (freq[0] * (freq[0] - 1)) / 2;
        for (int i = 1;i<12;i++){
            count += (freq[i] * freq[24-i]) ;
        }
        count += freq[12] * (freq[12] - 1) / 2;
        return count;
    }
}