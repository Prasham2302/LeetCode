class Solution {
    public boolean isBalanced(String num) {
        int sumOdd = 0;
        int sumEven = 0;
        for (int i = 0;i<num.length();i++) {
            int curr = num.charAt(i) - '0';    
            if (i % 2 == 0) {
                sumEven += curr;
            }
            else {
                sumOdd += curr;
            }
        }
        return sumOdd == sumEven;
    }
}