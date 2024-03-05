class Solution {
    public int minimumLength(String s) {
        int left=0, right = s.length()-1;
        StringBuilder sb = new StringBuilder(s);
        char prefix, suffix;
        while(left < right){
            
            if(sb.charAt(left) != sb.charAt(right))
                return right - left + 1;
            
            if(sb.charAt(left) == sb.charAt(right)){
                prefix = sb.charAt(left);
                suffix = sb.charAt(right);
                
                left++;
                right--;
                
                while(left<=right && sb.charAt(left) == prefix)
                    left++;
                while(left <=right && sb.charAt(right) == suffix)
                    right--;
            }
        }
        
        return right - left+1;
        
    }
}