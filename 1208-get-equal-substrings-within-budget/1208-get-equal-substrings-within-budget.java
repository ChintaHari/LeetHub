class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int left = 0, right = 0;
        int maxLength = Integer.MIN_VALUE;
        int currCost = 0;
        for(right = 0; right < s.length(); right++){
            currCost = currCost + Math.abs(s.charAt(right) - t.charAt(right));
            while(currCost > maxCost){
                currCost = currCost - Math.abs(s.charAt(left) - t.charAt(left));
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength == Integer.MIN_VALUE ? 0 : maxLength;
    }
}