class Solution {
    public boolean checkIfPangram(String sentence) {
        Set<Character> set = new HashSet<>();
        for(char ch : sentence.toCharArray()){
            // if(set.size() == 26)
            //     return true;
            set.add(ch);
        }
        return set.size() == 26 ?  true : false; 
    }
}