class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0)
            return 0;
        if(s.length() == 1)
            return 1;
        HashMap<Character, Integer> hm = new HashMap<>();
        int ans = 0, left = 0, right = 0;
        for(right = 0; right < s.length(); right++){
            char rightChar = s.charAt(right);
            hm.put(rightChar, hm.getOrDefault(rightChar, 0) + 1);
            while(left < s.length() && hm.get(rightChar) > 1){
               // ans = Math.max(ans, right - left);
                char leftChar = s.charAt(left);
                hm.put(leftChar, hm.getOrDefault(leftChar, 0) - 1);
                if(hm.get(leftChar) < 1)
                    hm.remove(leftChar);
                left++;
            }
           ans = Math.max(ans, right - left + 1); 
        }
        return ans;
    }
}