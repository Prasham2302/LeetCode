class Solution {
    public String longestPalindrome(String s) {
        int left = 0, right = 0;
        for (int i = 0;i<s.length();i++){
            List<Integer> expansion = expand(s, i, i);
            if (expansion.get(1) - expansion.get(0) > right - left){
                right = expansion.get(1);
                left = expansion.get(0);
            }
            expansion = expand(s, i, i+1);
            if (expansion.get(1) - expansion.get(0) > right - left){
                right = expansion.get(1);
                left = expansion.get(0);
            }
        }
        return s.substring(left, right);
    }
    public List<Integer> expand(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        List<Integer> expansion = new ArrayList<>(Arrays.asList(left+1, right));
        return expansion;
    }
}