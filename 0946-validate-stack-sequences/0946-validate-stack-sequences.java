class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i=0;
        for(int ele: pushed){
            while(!stack.isEmpty() && stack.peek() == popped[i]){
                stack.pop();
                i++;
            }
            stack.push(ele);
        }
        while(!stack.isEmpty() && stack.peek() == popped[i]){
            stack.pop();
            i++;
        }
        return stack.isEmpty();
        
    }
}