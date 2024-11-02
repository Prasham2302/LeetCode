class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] words = sentence.split(" ");
        String curr = words[0];
        // if (words.length < 2) {
        //     return false;
        // }
        if (words[words.length - 1].charAt(words[words.length-1].length()-1) != curr.charAt(0)) {
            return false;
        }
        for (int i =1;i<words.length;i++) {
            if(curr.charAt(curr.length()-1) != words[i].charAt(0)) {
                return false;
            }
            curr = words[i];
        }
        return true;
    }
}