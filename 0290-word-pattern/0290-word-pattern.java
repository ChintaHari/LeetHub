import java.util.*; 
class Solution {
    public boolean wordPattern(String pattern, String s) {
        StringTokenizer st = new StringTokenizer(s, " ");
        if(st.countTokens() != pattern.length())
            return false;
        
        //HashMap<Character, String> hm = new HashMap<>();
        HashMap<String, Character> hm = new HashMap<>();
        HashMap<Character, String> hm2 = new HashMap<>();
        for(int i=0; i<pattern.length(); i++){
            char patternChar = pattern.charAt(i);
            String currentToken = st.nextToken();
            
            if(hm.containsKey(currentToken) && !hm.get(currentToken).equals(patternChar) ||
              hm2.containsKey(patternChar) && !hm2.get(patternChar).equals(currentToken))
                return false;
            hm.put(currentToken, patternChar);
            hm2.put(patternChar, currentToken);
        }
        return true;
    }
}