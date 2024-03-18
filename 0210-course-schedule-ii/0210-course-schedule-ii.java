class Solution {
    List<List<Integer>> graph = new ArrayList<>();
    Stack<Integer> stack = new Stack<>();
    boolean recStack[], visited[];
    int[] result;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
       
        recStack = new boolean[numCourses];
        visited = new boolean[numCourses];
        result = new int[numCourses];
        
        for(int i=0; i<numCourses; i++)
            graph.add(new ArrayList<>());
        
        for(int[] prerequisite : prerequisites)
            graph.get(prerequisite[0]).add(prerequisite[1]);
        
        for(int course =0; course < numCourses; course++){
            if(! visited[course]){
                if(hasCycle(course))
                    return new int[]{};
            }
        }
        
//         System.out.println(stack);
        
//         for(int i=0; i<numCourses; i++)
//             result[i] = stack.pop();
        
//         //return result;
        return stack.stream().mapToInt(Integer::intValue).toArray();
    }
    
    public boolean hasCycle(int course){
        visited[course] = true;
        recStack[course] = true;
        
        for(int neighbour : graph.get(course)){
            if(! visited[neighbour]){
                if(hasCycle(neighbour))
                    return true;
            }
            else if(recStack[neighbour])
                return true;
        }
        
        stack.push(course);
        recStack[course] = false;
        return false;
    }
}