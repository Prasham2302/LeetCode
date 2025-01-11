class Solution {
    public boolean canConstruct(String s, int k) {
        if (s.length() < k) {
            return false;
        }
        int[] freq = new int[26];
        for (char curr : s.toCharArray()) {
            freq[curr-'a']++;
        }
        for(int i = 0;i<26;i++){
            if(freq[i] % 2 == 1){
                k--;
            }
            if (k < 0) {
                return false;
            }
        }
        return true;
    }
}