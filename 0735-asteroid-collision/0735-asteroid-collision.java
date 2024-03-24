class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int asteroid : asteroids){
            while(!stack.isEmpty() && asteroid < 0 && stack.peek() > 0){
                int diff = asteroid + stack.peek();
                if(diff < 0)
                    stack.pop();
                else if (diff > 0)
                    asteroid = stack.pop();
                else{
                    asteroid = 0;
                    stack.pop();
                }
            }
            if(asteroid != 0)
                stack.push(asteroid);
        }
        return stack.stream().mapToInt(Integer::intValue).toArray();
    }
}