class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
       if(s1.length() != s2.length())
           return false;
        
        List<Integer> differencesInIndices = new ArrayList<>();
        for(int i=0; i<s1.length(); i++)
            if(s1.charAt(i) != s2.charAt(i))
                differencesInIndices.add(i);
        if(differencesInIndices.isEmpty())
            return true;
        else if(differencesInIndices.size() == 2){
            if(s1.charAt(differencesInIndices.get(0)) == s2.charAt(differencesInIndices.get(1)) && 
              s1.charAt(differencesInIndices.get(1)) == s2.charAt(differencesInIndices.get(0)))
                return true;
            else
                return false;
        }
        else
            return false;
        
    }
}