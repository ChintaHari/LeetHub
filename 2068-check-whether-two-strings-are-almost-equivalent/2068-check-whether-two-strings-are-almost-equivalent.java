// class Solution {
//     public boolean checkAlmostEquivalent(String word1, String word2) {
//         HashMap<Character, Integer> word1Count = new HashMap<>();
//         HashMap<Character, Integer> word2Count = new HashMap<>();
        
//         for(int i=0; i<word1.length(); i++){
//             char word1Char = word1.charAt(i);
//             char word2Char = word2.charAt(i);
            
//             word1Count.put(word1Char, word1Count.getOrDefault(word1Char, 0) + 1);
//             word2Count.put(word2Char, word2Count.getOrDefault(word2Char, 0) + 1);
//         }
        
//         for(int i=0; i<word1.length(); i++){
//             char word1Char = word1.charAt(i);
//             char word2Char = word2.charAt(i);
            
//             if(Math.abs(word1Count.getOrDefault(word1Char, 0) - word2Count.getOrDefault(word1Char, 0)) > 3 ||
//                Math.abs(word1Count.getOrDefault(word2Char, 0) - word2Count.getOrDefault(word2Char, 0)) > 3)
//                 return false;
//         }
        
//         return true;
//     }
// }

class Solution {
    public boolean checkAlmostEquivalent(String word1, String word2) {
        int[] wordCount = new int[26];
        
        for (int i = 0; i < word1.length(); i++) {
            wordCount[word1.charAt(i) - 'a']++;
            wordCount[word2.charAt(i) - 'a']--;
        }

        for (int i = 0; i < wordCount.length; i++) 
            if (Math.abs(wordCount[i]) > 3) 
                return false;
        
        return true;
    }
}