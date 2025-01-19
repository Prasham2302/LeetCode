class Node {
    Node prev;
    Node next;
    String val;
    Node(Node prev, Node next, String val) {
        this.val = val;
        this.prev = prev;
        this.next = next;
    }
}

class BrowserHistory {
    Node curr;
    public BrowserHistory(String homepage) {
        curr = new Node(null, null, homepage);
    }
    
    public void visit(String url) {
        Node newNode = new Node(curr, null, url);
        curr.next = newNode;
        curr = newNode;
        // System.out.println("Added "+curr.val +" to "+curr.prev.val);
    }
    
    public String back(int steps) {
        while (curr.prev != null && steps != 0) {
            curr = curr.prev;
            steps--;
        }
        return curr.val;
    }
    
    public String forward(int steps) {
        while(curr.next != null && steps != 0) {
            curr = curr.next;
            steps--;
        }
        return curr.val;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */