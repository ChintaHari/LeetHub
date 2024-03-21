class TrieNode{
    Map<Character, TrieNode> map = new HashMap<>();
    boolean isWord = false;
}
class Trie {
    
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode currNode = root;
        for(char ch: word.toCharArray()){
            if(! currNode.map.containsKey(ch))
                currNode.map.put(ch, new TrieNode());
            currNode = currNode.map.get(ch);
        }
        currNode.isWord = true;
    }
    
    public boolean search(String word) {
        TrieNode currNode = root;
        for(char ch: word.toCharArray()){
            if(! currNode.map.containsKey(ch))
                return false;
            currNode = currNode.map.get(ch);
        }
        return currNode.isWord ;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode currNode = root;
        for(char ch: prefix.toCharArray()){
            if(! currNode.map.containsKey(ch))
                return false;
            currNode = currNode.map.get(ch);
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