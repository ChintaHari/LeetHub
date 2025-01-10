class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] maxFrequency = new int[26];
        
        for (String subset : words2) {
            int[] frequency = new int[26];
            for (char c : subset.toCharArray()) 
                frequency[c - 'a']++;
            
            for (int i = 0; i < 26; i++) 
                maxFrequency[i] = Math.max(maxFrequency[i], frequency[i]);
        }
        
        List<String> universalStrings = new ArrayList<>();
        for (String word : words1) {
            int[] frequency = new int[26];
            for (char c : word.toCharArray()) 
                frequency[c - 'a']++;
            
            boolean isUniversal = true;
            for (int i = 0; i < 26; i++) {
                if (frequency[i] < maxFrequency[i]) {
                    isUniversal = false;
                    break;
                }
            }
            
            if (isUniversal)
                universalStrings.add(word);
        }
        return universalStrings;
    }
}

