class Solution {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch != ']')
                stack.push(ch);
            else{
                StringBuilder sb = new StringBuilder();
                while(!stack.isEmpty() && stack.peek() != '['){
                    sb.insert(0, stack.pop());
                }
                
                stack.pop();
                
                StringBuilder num = new StringBuilder();
                while(!stack.isEmpty() && Character.isDigit(stack.peek())){
                    num.insert(0, stack.pop());
                }
                
                int number = Integer.parseInt(num.toString());
                
                String repeatedPart = sb.toString().repeat(number);
                
                for(char c : repeatedPart.toCharArray())
                    stack.push(c);
                
            }
        }
            
        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty())
            result.insert(0, stack.pop());
        
        return result.toString();
    }
}