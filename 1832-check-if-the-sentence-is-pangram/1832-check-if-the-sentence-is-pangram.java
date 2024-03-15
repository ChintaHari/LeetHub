class Solution {
    public boolean checkIfPangram(String sentence) {
        Set<Character> set = new HashSet<>();
        for(char ch : sentence.toCharArray()){
            set.add(ch);
            if(set.size() == 26)
                 return true;  
        }
       // return set.size() == 26 ?  true : false; 
        return false;
    }
}