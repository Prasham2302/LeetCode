class Node {
    HashMap<Character, Node> children;
    boolean isEnd;
    Node() {
        this.isEnd = false;
        this.children = new HashMap<>();
    }
}

class Trie {
    Node root;
    Trie() {
        this.root = new Node();
    }
    void insertWord(String word) {
        Node curr = root;
        int index = 0;
        while (index < word.length()) {
            char charToInsert = word.charAt(index);
            if (!curr.children.containsKey(charToInsert)) {
                curr.children.put(charToInsert, new Node());
            }
            curr = curr.children.get(charToInsert);
            index++;
        }
        curr.isEnd = true;
    }
    boolean searchWord(String word, Node currNode, int index, int count) {
        if (count > 2) {
            return false;
        }
        if (index == word.length()) {
            if (currNode.isEnd)
                return true;
            return false;
        }
        boolean ans = false;
        for (Character currChar : currNode.children.keySet()) {
            if (currChar == word.charAt(index)) {
                ans = ans || searchWord(word, currNode.children.get(currChar), index+1,count);
            } else {
                ans = ans || searchWord(word, currNode.children.get(currChar), index+1,count+1);
            }
        }
        return ans;
    }
}

class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        Trie myTrie = new Trie();
        for (String word : dictionary) {
            myTrie.insertWord(word);
        }
        List<String> ans = new ArrayList<>();
        for (String query: queries) {
            if (myTrie.searchWord(query, myTrie.root, 0, 0)) {
                ans.add(query);
            }
        }
        return ans;
    }
}