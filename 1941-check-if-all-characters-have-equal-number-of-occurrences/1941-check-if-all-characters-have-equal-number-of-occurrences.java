class Solution {
    public boolean areOccurrencesEqual(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for(char ch : s.toCharArray())
            hm.put(ch, hm.getOrDefault(ch,0) + 1);
        
        Set<Integer> set = new HashSet<>(hm.values());
        return set.size() == 1 ? true : false;
    }
}