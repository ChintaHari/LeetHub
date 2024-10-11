class Solution {
    List<List<Integer>> graph = new ArrayList<>();
    Stack<Integer> stack = new Stack<>();
    boolean[] visited, recStack;
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited = new boolean[numCourses];
        recStack = new boolean[numCourses];
        
        for(int i=0; i<numCourses; i++)
            graph.add(new ArrayList<>());
        
        // for(int i=0; i<prerequisites.length; i++)
        //     graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        
        for(int[] prerequisite : prerequisites)
            graph.get(prerequisite[0]).add(prerequisite[1]);
        
        
        for(int i=0; i<numCourses; i++){
            if(! visited[i]){
                if(hasCycle(i))
                    return false;
            }
        }
        
        return stack.size() == numCourses ? true : false;
    }
    
    public boolean hasCycle(int course){
        visited[course] = true;
        recStack[course] = true;
        
        for(int neighbour : graph.get(course)){
            if(! visited[neighbour]){
                if(hasCycle(neighbour))
                    return false;
            }
            else if(recStack[neighbour])
                return false;
        }
        
        stack.push(course);
        recStack[course] = false;
        return false;
    }
}