class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> hm = new HashMap<>();
        HashMap<Character, Character> hm2 = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            
            if((hm.containsKey(sChar) && !hm.get(sChar).equals(tChar)) || (hm2.containsKey(tChar) && !hm2.get(tChar).equals(sChar)))
                return false;
            hm.put(sChar, tChar);
            hm2.put(tChar, sChar);
        }
        return true;
    }
}