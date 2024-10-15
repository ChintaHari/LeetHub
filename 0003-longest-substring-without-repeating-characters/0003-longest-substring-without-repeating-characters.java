class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int left =0, right =0;
        int maxLength = Integer.MIN_VALUE;
        Set<Character> set = new HashSet<>();
        for(right = 0; right < s.length(); right++){
            char ch = s.charAt(right);
            
            while(set.contains(ch)){
                set.remove(s.charAt(left));
                left++;
            }
            
            set.add(ch);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength == Integer.MIN_VALUE ? 0 : maxLength ;
    }
}