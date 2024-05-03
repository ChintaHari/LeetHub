import java.util.*;
class Solution {
    public int compareVersion(String version1, String version2) {
        String[] tokens1 = version1.split("\\.");
        String[] tokens2 = version2.split("\\.");
        
        int maxLen = Math.max(tokens1.length, tokens2.length);
        
        for (int i = 0; i < maxLen; i++) {
            int firstToken = i < tokens1.length ? Integer.parseInt(tokens1[i]) : 0;
            int secondToken = i < tokens2.length ? Integer.parseInt(tokens2[i]) : 0;
            
      
            if (firstToken > secondToken) 
                return 1;
            
            if (firstToken < secondToken) {
                return -1;
            }
        }
        
        return 0;
    }
}