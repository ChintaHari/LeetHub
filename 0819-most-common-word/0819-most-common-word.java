class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        
        String normalizedString = paragraph.toLowerCase().replaceAll("[!?',;.]", " ");
        String[] words = normalizedString.split("\\s+");
        
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
        
        Map<String, Integer> wordCountMap = new HashMap<>();
        
        for(String word : words){
            if(!bannedSet.contains(word))
                wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }
        
        int maxCount = 0;
        String resultWord = "";
        
        for(Map.Entry<String, Integer> entry : wordCountMap.entrySet()){
            if(entry.getValue() > maxCount){
                maxCount = entry.getValue();
                resultWord = entry.getKey();
            }
        }
        return resultWord;
    }
}