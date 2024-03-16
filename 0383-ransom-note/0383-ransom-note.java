class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for(char ch : ransomNote.toCharArray())
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        for(char ch : magazine.toCharArray()){
            if(hm.containsKey(ch)){
                hm.put(ch, hm.get(ch) - 1);
                if(hm.get(ch) == 0)
                    hm.remove(ch);
            }
        }
        
        return hm.size() == 0 ? true : false;
    }
}