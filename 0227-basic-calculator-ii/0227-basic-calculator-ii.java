class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        Set<Character> operations = new HashSet<>(Arrays.asList('+', '-', '*', '/'));
        int curr = 0;
        char currentOperator = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) 
                curr = curr * 10 + (c - '0'); 
            
            if (operations.contains(c) || i == s.length() - 1) {
                if (currentOperator == '+') 
                    stack.push(curr);
                else if (currentOperator == '-') 
                    stack.push(-curr);
                else if (currentOperator == '*') 
                    stack.push(stack.pop() * curr);
                else if (currentOperator == '/') 
                    stack.push(stack.pop() / curr);
                
                curr = 0;
                currentOperator = c;
            }
        }

        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }
}
