class Solution {
    public int minLength(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0;i<s.length();i++){
            char curr = s.charAt(i);
            if (stack.isEmpty())
                stack.push(curr);
            else if ((stack.peek() == 'A' && curr == 'B') || (stack.peek() == 'C' && curr == 'D'))
                stack.pop();
            else
                stack.push(curr);
        }
        return stack.size();
    }
}