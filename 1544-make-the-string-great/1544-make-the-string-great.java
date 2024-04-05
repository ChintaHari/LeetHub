class Solution {
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()){
            if((!stack.isEmpty() && Character.toUpperCase(ch) == stack.peek() && ch!=stack.peek()) ||
              (!stack.isEmpty() && Character.toUpperCase(stack.peek()) == ch && ch!=stack.peek()))
                stack.pop();
            else
                stack.push(ch);
            
        }
        while(!stack.isEmpty())
            sb.append(stack.pop());
        return sb.reverse().toString();
    }
}