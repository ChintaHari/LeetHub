class Solution {

    public List<String> wordBreak(String s, List<String> wordDict) {
       
        Map<Integer, List<String>> dp = new HashMap<>();

       
        for (int startIdx = s.length(); startIdx >= 0; startIdx--) {
          
            List<String> validSentences = new ArrayList<>();

           
            for (int endIdx = startIdx; endIdx < s.length(); endIdx++) {
               
                String currentWord = s.substring(startIdx, endIdx + 1);

               
                if (isWordInDict(currentWord, wordDict)) {
                    
                    if (endIdx == s.length() - 1) {
                        validSentences.add(currentWord);
                    } else {
                       
                        List<String> sentencesFromNextIndex = dp.get(
                            endIdx + 1
                        );
                        for (String sentence : sentencesFromNextIndex) {
                            validSentences.add(currentWord + " " + sentence);
                        }
                    }
                }
            }
           
            dp.put(startIdx, validSentences);
        }
      
        return dp.getOrDefault(0, new ArrayList<>());
    }

   
    private boolean isWordInDict(String word, List<String> wordDict) {
        return wordDict.contains(word);
    }
}