class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0, right = 0;
        int[] freq = new int[26];
        int mostFreqChar = 0;
        int ans = 0;
        while (right < s.length()) {
            freq[s.charAt(right)-'A']++;
            mostFreqChar = Math.max(mostFreqChar, freq[s.charAt(right)-'A']);
            if (right - left - mostFreqChar + 1 > k) {
                freq[s.charAt(left)-'A']--;
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }
}