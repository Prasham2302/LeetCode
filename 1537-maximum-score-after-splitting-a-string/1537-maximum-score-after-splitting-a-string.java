class Solution {
    public int maxScore(String s) {
        int[] zeros = new int[s.length()];
        int[] ones = new int[s.length()];
        if(s.charAt(0) == '0'){
            zeros[0]++;
        }
        if(s.charAt(s.length()-1) == '1'){
            ones[s.length()-1]++;
        }
        for(int i = 1;i<s.length();i++){
            int end = s.length() - 1 -i;
            zeros[i] = zeros[i-1];
            if(s.charAt(i) == '0'){
                zeros[i]++;
            }
            ones[end] = ones[end+1];
            if(s.charAt(end) == '1'){
                ones[end]++;
            }
        }
        int max = zeros[0] + ones[s.length()-1];
        for(int i = 1;i<s.length()-1;i++){
            max = Math.max(zeros[i] + ones[i], max);
        }
        // System.out.println(Arrays.toString(zeros) +" "+Arrays.toString(ones));
        return max;
    }
}