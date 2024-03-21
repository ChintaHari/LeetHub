class TrieNode{
    Map<Character, TrieNode> map = new HashMap<>();
    List<String> suggestions = new ArrayList<>();
}

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        
        TrieNode root = new TrieNode();
        for(String word: products)
            insertWord(root, word);
        
        List<List<String>> result = new ArrayList<>();
        TrieNode currNode = root;
        for(char ch: searchWord.toCharArray()){
            currNode = currNode != null ? currNode.map.get(ch) : null;
            result.add(currNode == null ? Collections.emptyList() : currNode.suggestions);
        }
        
        return result;
    }
    
    public void insertWord(TrieNode root, String word){
        TrieNode currNode = root;
        for(char ch : word.toCharArray()){
            if(!currNode.map.containsKey(ch))
                currNode.map.put(ch, new TrieNode());
            currNode = currNode.map.get(ch);
            
            if(currNode.suggestions.size() < 3)
                currNode.suggestions.add(word);
        }
    }
}