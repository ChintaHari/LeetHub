class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(char ch : s.toCharArray()){
            if(ch == '*' && !stack.isEmpty())
                stack.pop();
            else if (ch != '*')
                stack.push(ch);
        }
        
        char[] result = new char[stack.size()];
        for(int i = stack.size() - 1; i>=0 && !stack.isEmpty(); i--){
            result[i] = stack.pop();
        }
        
        return new String(result);
    }
}