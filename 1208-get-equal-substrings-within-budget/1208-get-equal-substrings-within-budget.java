class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int max = Integer.MIN_VALUE;
        int curr = 0;
        int left = 0, right = 0;
        for(right = 0; right < s.length(); right++){
            curr = curr + Math.abs(s.charAt(right) - t.charAt(right));
            while(curr > maxCost){
                curr = curr - Math.abs(s.charAt(left) - t.charAt(left));
                left ++;
            }
            
            max = Math.max(max, right - left + 1);
        }
        return max == Integer.MIN_VALUE ? 0 : max;
        
    }
}