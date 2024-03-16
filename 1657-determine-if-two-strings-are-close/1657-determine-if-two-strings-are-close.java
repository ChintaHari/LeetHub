class Solution {
    public boolean closeStrings(String word1, String word2) {
        
        if(word1.length() != word2.length())
            return false;
        
        HashMap<Character, Integer> hm = new HashMap<>();
        HashMap<Character, Integer> hm2 = new HashMap<>();
        
        for(int i=0; i<word1.length(); i++){
            char word1Char = word1.charAt(i);
            char word2Char = word2.charAt(i);
            
            hm.put(word1Char, hm.getOrDefault(word1Char, 0) + 1);
            hm2.put(word2Char, hm2.getOrDefault(word2Char, 0) + 1);
        }
        
        if(! hm.keySet().equals(hm2.keySet()))
            return false;
        
        List<Integer> list1 = new ArrayList<>(hm.values());
        List<Integer> list2 = new ArrayList<>(hm2.values());
        
        Collections.sort(list1);
        Collections.sort(list2);
        
        return list1.equals(list2);
        
    }
}