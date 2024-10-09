class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(Character curr : s.toCharArray()){
            if (!stack.isEmpty() && stack.peek() == '(' && curr == ')')
                stack.pop();
            else
                stack.push(curr);
        }
        return stack.size();
    }
}