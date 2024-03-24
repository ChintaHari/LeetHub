class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        Set<Character> operations = new HashSet<>(Arrays.asList('+', '-', '/', '*'));
        int currentNumber = 0;
        char currentOperator = '+';
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch))
                currentNumber = (currentNumber * 10) + (ch - '0');
            if(operations.contains(ch) || i == s.length() -1){
                if(currentOperator == '+')
                    stack.push(currentNumber);
                if(currentOperator == '-')
                    stack.push(-currentNumber);
                if(currentOperator == '*')
                    stack.push(currentNumber * stack.pop());
                if(currentOperator == '/')
                    stack.push(stack.pop() / currentNumber);
                
                currentNumber = 0;
                currentOperator = ch;
            }
        }
        return stack.stream().mapToInt(Integer::intValue).sum();
    }
}