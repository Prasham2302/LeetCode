class Solution {
    public int minChanges(String s) {
        int count = 0;
        // try to partition the string into minimum size i.e. 2
        // Look in pairs
        // Any pair needs change, increase counter by 1.
        for (int i = 0;i<s.length();i+=2) {
            if (s.charAt(i) != s.charAt(i+1)) {
                count++;
            }
        }
        return count;
    }
}