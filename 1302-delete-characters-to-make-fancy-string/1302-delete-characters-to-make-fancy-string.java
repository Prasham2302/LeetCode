class Solution {
    public String makeFancyString(String s) {
        StringBuilder answer = new StringBuilder();
        int count = 0;
        char matchChar = '\u0000';
        for(char curr : s.toCharArray()){
            if (curr != matchChar){
                count = 1;
                matchChar = curr;
                answer.append(curr);
            }
            else{
                count++;
                if (count < 3){
                    answer.append(curr);
                }
            }
        }
        return answer.toString();
    }
}