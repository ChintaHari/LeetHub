class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(char ch: s.toCharArray()){
            if(!stack.isEmpty() && ch=='*')
                stack.pop();
            else if(ch != '*')
                stack.push(ch);
        }
        while(!stack.isEmpty())
            sb.append(stack.pop());
        return sb.reverse().toString();
    }
}