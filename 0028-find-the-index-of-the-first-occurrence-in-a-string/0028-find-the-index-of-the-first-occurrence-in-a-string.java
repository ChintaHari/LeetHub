class Solution {
    public int strStr(String haystack, String needle) {
        int haystackLength = haystack.length();
        int needleLength = needle.length();
        
        for(int windowIndexStart = 0; windowIndexStart <= haystackLength - needleLength; windowIndexStart++){
            for(int i = 0; i < needleLength; i++){
                
                if(needle.charAt(i) != haystack.charAt(windowIndexStart + i))
                    break;
                
                if(i == needleLength - 1)
                    return windowIndexStart;
            }
        }
        return -1;
    }
}