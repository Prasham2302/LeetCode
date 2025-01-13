class Solution {
    public int minimumLength(String s) {
        int[] freq = new int[26];
        for(int i = 0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }
        int count = 0;
        for(int i = 0;i<26;i++) {
            if (freq[i]%2==1) {
                count += freq[i] - 1;
                continue;
            }
            count += freq[i] > 2 ? freq[i] - 2: 0;
        }
        return s.length()-count;
    }
}