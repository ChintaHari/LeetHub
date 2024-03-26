class TrieNode{
    Map<Character, TrieNode> map = new HashMap<>();
    List<String> suggestions = new ArrayList<>();
}
class Solution {
    TrieNode root = new TrieNode();
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        for(String product : products)
            insertWord(product);
        
        List<List<String>> result = new ArrayList<>();
        TrieNode node = root;
        for(char ch : searchWord.toCharArray()){
            node = node == null? null : node.map.get(ch);
            if(node == null)
                result.add(Collections.emptyList());
            else
                result.add(node.suggestions);
        }
        
        return result;
        
    }
    
    public void insertWord(String word){
        TrieNode node = root;
        for(char ch: word.toCharArray()){
            if(! node.map.containsKey(ch))
                node.map.put(ch, new TrieNode());
            node = node.map.get(ch);
            
            if(node.suggestions.size() < 3)
                node.suggestions.add(word);
        }
    }
}