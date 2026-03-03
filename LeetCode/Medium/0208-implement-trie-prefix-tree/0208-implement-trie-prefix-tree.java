class Trie {

    class Node {
        Node[] children = new Node[26];
        boolean isWord = false;
    }

    Node root = new Node();
    
    public void insert(String word) {
        Node cur = root;

        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (cur.children[idx] == null)
                cur.children[idx] = new Node();

            cur = cur.children[idx];
        }

        cur.isWord = true;
    }
    
    public boolean search(String word) {
        Node cur = root;

        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (cur.children[idx] == null)
                return false;

            cur = cur.children[idx];
        }

        return cur.isWord;
    }
    
    public boolean startsWith(String prefix) {
        Node cur = root;

        for (char c : prefix.toCharArray()) {
            int idx = c - 'a';
            if (cur.children[idx] == null)
                return false;
            
            cur = cur.children[idx];
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */