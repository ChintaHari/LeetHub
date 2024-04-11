class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0)
            return 0;
        if(s.length() == 1)
            return 1;
        
        HashMap<Character, Integer> map = new HashMap<>();
        int ans = 0, left = 0, right = 0;
        for(right =0; right < s.length(); right++){
            char rightChar = s.charAt(right);
            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);
            
            while(left < s.length() && map.get(rightChar) > 1){
                char leftChar = s.charAt(left);
                map.put(leftChar, map.getOrDefault(leftChar ,0) - 1);
                if(map.get(leftChar) == 0)
                    map.remove(leftChar);
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}