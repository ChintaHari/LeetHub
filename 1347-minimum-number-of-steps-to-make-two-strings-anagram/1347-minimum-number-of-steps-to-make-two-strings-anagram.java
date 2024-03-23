class Solution {
    public int minSteps(String s, String t) {
        
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();
        
        for(int i=0; i<s.length(); i++){
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i) ,0)+1);
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i) ,0)+1);
        }
        
        int count = 0;
        for(char key : sMap.keySet()){
            int needed = sMap.get(key);
            int available = tMap.getOrDefault(key, 0);
            count = count + Math.max(0, needed - available);
        }
        return count;
    }
}