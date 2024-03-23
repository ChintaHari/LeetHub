class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        List<Integer> differentIndices = new ArrayList<>();
        for(int i=0; i<s1.length(); i++)
            if(s1.charAt(i) != s2.charAt(i))
                differentIndices.add(i);
        
        if(differentIndices.size() == 0)
            return true;
        else if(differentIndices.size() == 2){
            if(s1.charAt(differentIndices.get(0)) == s2.charAt(differentIndices.get(1))  &&
              s1.charAt(differentIndices.get(1)) == s2.charAt(differentIndices.get(0)))
                return true;
            else
                return false;
        }
        else
            return false;
        
    }
}