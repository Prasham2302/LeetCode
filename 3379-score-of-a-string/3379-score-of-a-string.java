class Solution {
    public int scoreOfString(String s) {
        int sum = 0;
        int prev = s.charAt(0);
        for (int i = 1;i<s.length();i++) {
            int curr = s.charAt(i) - 0;
            sum += Math.abs(prev - curr);
            prev = curr;
        }
        return sum;
    }
}