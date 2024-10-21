class Solution {
    public int maxUniqueSplit(String s) {
        HashSet<String> set = new HashSet<>();
        return backtrack(s, set, 0);
    }
    int backtrack(String s, HashSet<String> set, int start) {
        if (start == s.length()) {
            return 0;
        }
        int max = 0;
        for (int end = start + 1; end <= s.length() ;end++){
            String subst = s.substring(start, end);
            if (!set.contains(subst)) {
                set.add(subst);
                max = Math.max(backtrack(s, set, end) + 1, max);
                set.remove(subst);
            }
        }
        return max;
    }
}