class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
    for (int ast : asteroids) {
        boolean destroyed = false;
        while (!stack.isEmpty() && ast < 0 && stack.peek() > 0) {
            if (Math.abs(ast) > Math.abs(stack.peek())) {
                stack.pop();
                continue; 
            } else if (Math.abs(ast) == Math.abs(stack.peek())) { 
                stack.pop();
            }
            destroyed = true;
            break;
        }
        if (!destroyed) {
            stack.push(ast); 
        }
    }

   List<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        Collections.reverse(list);

        return list.stream().mapToInt(Integer::intValue).toArray();

        
    }
}