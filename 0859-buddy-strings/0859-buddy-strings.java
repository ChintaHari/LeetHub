class Solution {
    public boolean buddyStrings(String s, String goal) {
        if(s.length() != goal.length())
            return false;
        
        if (s.equals(goal)) {
            Map<Character, Integer> charCountMap = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char currentChar = s.charAt(i);
                int count = charCountMap.getOrDefault(currentChar, 0) + 1;
                charCountMap.put(currentChar, count);

                if (count > 1) {
                    return true;
                }
            }
            return false;
        }
        
        List<Integer> differentIndices = new ArrayList<>();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) != goal.charAt(i))
                differentIndices.add(i);
        }
        
        if(differentIndices.size() == 0)
            return false;
        else if(differentIndices.size() == 2){
            if(s.charAt(differentIndices.get(0)) == goal.charAt(differentIndices.get(1)) 
               && s.charAt(differentIndices.get(1)) == goal.charAt(differentIndices.get(0)) )
                return true;
            else
                return false;
        }
        else
            return false;
        
    }
}