class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i = sandwiches.length - 1; i >= 0; i--) 
            stack.push(sandwiches[i]);
        
        for(int student : students) 
            queue.offer(student);
        
        int cannotEat = 0;
        while(!stack.isEmpty()) {
            int currentTopSandwich = stack.peek();
            int currentStudent = queue.peek();
            
            if(currentStudent == currentTopSandwich) {
                stack.pop();
                queue.poll();
                cannotEat = 0; 
            } else {
                queue.offer(queue.poll()); 
                cannotEat++;
            }
            
            if(cannotEat == queue.size()) 
                break;
            
        }
        return queue.size(); 
    }
}
