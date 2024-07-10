class Solution {
    public int minOperations(String[] logs) {
        Stack<String> stack = new Stack<>();
        stack.push("MAIN");
        
        for(String log : logs){
            if(log.equals("./"))
                continue;
            else if(log.equals("../")){
                if(stack.peek() == "MAIN")
                    continue;
                else
                    stack.pop();
            }
            else
                stack.push(log);
        }
        
        return stack.size() - 1;
        
    }
}