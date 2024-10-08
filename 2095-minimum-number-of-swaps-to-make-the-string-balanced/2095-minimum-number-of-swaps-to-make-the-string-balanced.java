class Solution {
    public int minSwaps(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for (int i = 0;i<s.length();i++){
            char curr = s.charAt(i);
            if (curr == '['){
                stack.push(curr);
            }
            else{
                if (!stack.isEmpty()){
                    stack.pop();
                }
                else{
                    count++;
                }
            }
        }
        // System.out.println(stack);
        return (count + 1)/2;
    }
}