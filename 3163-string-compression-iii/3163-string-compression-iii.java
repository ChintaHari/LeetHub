class Solution {

    public String compressedString(String word) {
        StringBuilder result = new StringBuilder("");
        int pos = 0;
        while(pos < word.length()) {
            int consecutiveCount = 0;
            char currentChar = word.charAt(pos);
            while(pos < word.length() && consecutiveCount < 9 && word.charAt(pos) == currentChar) {
                consecutiveCount++;
                pos++;
            }
            result.append(consecutiveCount).append(currentChar);
        }

        return result.toString();
    }
    
}