class Solution {
    public boolean checkValidString(String s) {
        int open=0, close=0;
        for(int i=0; i<s.length(); i++){
            char leftChar = s.charAt(i);
            char rightChar = s.charAt(s.length() -1 - i);
            
            if(leftChar == '(' || leftChar == '*')
                open++;
            else
                open--;
            
            if(rightChar == ')' || rightChar == '*')
                close++;
            else
                close--;
            
            if(open < 0 || close < 0)
            return false;
        }
        
        return true;
        
    }
}