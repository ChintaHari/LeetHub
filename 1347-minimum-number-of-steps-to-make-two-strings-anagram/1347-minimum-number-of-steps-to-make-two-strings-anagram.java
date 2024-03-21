class Solution {
    public int minSteps(String s, String t) {
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();
        
        int count =0;
        for(char ch : s.toCharArray())
            sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);
        
        for(char ch: t.toCharArray())
             tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);
        
        for(char key : sMap.keySet()){
            int needed = sMap.get(key);
            int availableOnHand = tMap.getOrDefault(key, 0);
            count = count + Math.max(0, needed - availableOnHand);
        }
        return count;
    }
}