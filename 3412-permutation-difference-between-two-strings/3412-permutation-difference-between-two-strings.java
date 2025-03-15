class Solution {
    public int findPermutationDifference(String s, String t) {
        int sum=0;
        for(int i=0;i<s.length();i++){
            int j=t.indexOf(s.charAt(i));
            sum=sum+Math.abs(i-j);
        }
        return sum;
    }
}