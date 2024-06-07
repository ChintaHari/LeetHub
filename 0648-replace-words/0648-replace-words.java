class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
       
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        //int i = 0;
        
        for(int i = 0; i < words.length; i++){
             int minLength = Integer.MAX_VALUE;
            for(String dict : dictionary){
                int dictLength = dict.length();
                if((words[i].length() > dictLength) && (dict.equals(words[i].substring(0, dictLength))) && (dictLength < minLength)){
                    words[i] = dict;
                    minLength = dictLength;
                }
            }
             result.append(words[i] + " ");
        }
        
        return result.toString().trim();
    }
}