class TextEditor {
    Stack<Character> left;
    Stack<Character> right;
    public TextEditor() {
        this.left = new Stack<>();
        this.right = new Stack<>();
    }
    
    public void addText(String text) {
        for (char curr : text.toCharArray())
            left.push(curr);
    }
    
    public int deleteText(int k) {
        int count = 0;
        while(k-- > 0 && left.size() > 0) {
            left.pop();
            count++;
        }
        return count;
    }
    
    public String cursorLeft(int k) {
        while (k-- > 0 && left.size() > 0) {
            right.push(left.pop());
        }
        return minString();
    }
    
    public String cursorRight(int k) {
        while (k-- > 0 && right.size() > 0) {
            left.push(right.pop());
        }
        return minString();
    }
    public String minString() {
        StringBuilder str = new StringBuilder();
        int count = 10;
        while (!left.isEmpty() && count > 0) {
            str.append(left.pop());
            count--;
        }
        String ret = str.reverse().toString();
        for (int i = 0;i<str.length();i++) {
            left.push(str.charAt(i));
        }
        return ret;

    }
}

/**
 * Your TextEditor object will be instantiated and called as such:
 * TextEditor obj = new TextEditor();
 * obj.addText(text);
 * int param_2 = obj.deleteText(k);
 * String param_3 = obj.cursorLeft(k);
 * String param_4 = obj.cursorRight(k);
 */