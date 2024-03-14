class Solution {
    public String reverseOnlyLetters(String s) {
        int left = 0, right = s.length() -1;
        char[] charArray = s.toCharArray();
        while(left < right){
            if(Character.isLetter(charArray[left]) && Character.isLetter(charArray[right])){
                char temp =  charArray[left];
                charArray[left] = charArray[right];
                charArray[right] = temp;
                
                left++;
                right--;
            }
            
            if(! Character.isLetter(charArray[left]))
                left ++;
            
            if(! Character.isLetter(charArray[right]))
                right--;
        }
        return new String(charArray);
        
    }
}