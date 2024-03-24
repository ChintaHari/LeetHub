class Solution {
    boolean[] visited, recStack;
    int[] result;
    HashMap<Integer, List<Integer>> hm = new HashMap<>();
    Stack<Integer> stack = new Stack<>();
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        visited = new boolean[numCourses];
        recStack = new boolean[numCourses];
        
        for(int i=0; i<numCourses; i++)
            hm.put(i, new ArrayList<>());
        
        for(int[] prerequisite : prerequisites)
            hm.get(prerequisite[0]).add(prerequisite[1]);
        
        for(int course = 0; course < numCourses; course++){
            if(!visited[course])
                if(hasCycle(course))
                    return new int[]{};
        }
         
//         int[] order = new int[numCourses];
//         for(int i = 0; i < numCourses; i++)
//             order[i] = stack.pop();
        
//         return order;
        return stack.stream().mapToInt(Integer::intValue).toArray();

    }
    
    public boolean hasCycle(int course){
        visited[course] = true;
        recStack[course] = true;
        
        for(int neighbour : hm.get(course)){
            if(! visited[neighbour]){
                if(hasCycle(neighbour))
                    return true;
            }
            else if(recStack[neighbour])
                return true;
        }
        stack.push(course);
        recStack[course] = false;
        return recStack[course];
    }
}