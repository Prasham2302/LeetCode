class Solution {
    public String compressedString(String word) {
        StringBuilder str = new StringBuilder();
        int count = 1;
        char prevChar = word.charAt(0);
        for (int i = 1;i<word.length();i++) {
            char currChar = word.charAt(i);
            if (prevChar != currChar) {
                if (count > 0) {
                    str.append(count);
                    str.append(prevChar);
                }
                prevChar = currChar;
                count = 0;
            }
            count++;
            if (count == 9) {
                str.append(count);
                str.append(prevChar);
                count = 0;
            }
        }
        if (count > 0) {
            str.append(count);
            str.append(prevChar);
        }
        return str.toString();
    }
}