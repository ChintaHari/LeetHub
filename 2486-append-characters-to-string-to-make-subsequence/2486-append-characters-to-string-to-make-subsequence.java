class Solution {
    public int appendCharacters(String s, String t) {
        int i = 0, j = 0;
        int sLength = s.length(), tLength = t.length();
        
        while (i < sLength && j < tLength) {
            if (s.charAt(i) == t.charAt(j)) {
                j++;
            }
            i++;
        }
        
        return tLength - j;
    }
}
