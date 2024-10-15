class Solution {
    public long minimumSteps(String s) {
        long swaps = 0;
        long countOne = 0;
        for(char curr : s.toCharArray()) {
            if (curr == '1') {
                countOne++;
            }
            else {
                swaps+=countOne;
            }
        }
        return swaps;
    }
}