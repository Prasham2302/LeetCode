class Solution {
    public long numberOfWays(String s) {
        HashMap<String, Long> map = new HashMap<>();
        long zero = 0;
        for (int i = 0;i<s.length();i++) {
            if (s.charAt(i) == '0') {
                map.put("0", map.getOrDefault("0",zero)+1);
                map.put("10", map.getOrDefault("1",zero) + map.getOrDefault("10",zero));
                map.put("010", map.getOrDefault("01",zero) + map.getOrDefault("010",zero));
            } else {
                map.put("1", map.getOrDefault("1",zero)+1);
                map.put("01", map.getOrDefault("0",zero) + map.getOrDefault("01",zero));
                map.put("101", map.getOrDefault("10",zero) + map.getOrDefault("101",zero));
            }
        }
        return map.getOrDefault("101", zero) + map.getOrDefault("010", zero);
    }
}