class Solution {

    public int isPrefixOfWord(String sentence, String searchWord) {
        if (sentence == null || searchWord == null || searchWord.length() > sentence.length()) 
            return -1;
        
        int currentWordPosition = 1;
        int currentIndex = 0;
        int sentenceLength = sentence.length();

        while (currentIndex < sentenceLength) {
            while (currentIndex < sentenceLength && sentence.charAt(currentIndex) == ' ') {
                currentWordPosition++;
                while (currentIndex < sentenceLength && sentence.charAt(currentIndex) == ' ') {
                    currentIndex++;
                }
            }

            int matchCount = 0;
            while (currentIndex < sentenceLength && matchCount < searchWord.length() && sentence.charAt(currentIndex) == searchWord.charAt(matchCount)) {
                currentIndex++;
                matchCount++;
            }

            if (matchCount == searchWord.length()) 
                return currentWordPosition;
            
            while (currentIndex < sentenceLength && sentence.charAt(currentIndex) != ' ') {
                currentIndex++;
            }
        }
        return -1;
    }
}