class Solution {
    List<List<Integer>> graph = new ArrayList<>();
    boolean[] visited, recStack;
    Stack<Integer> stack = new Stack<>();
    int[] result;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        visited = new boolean[numCourses];
        recStack = new boolean[numCourses];
        result = new int[numCourses];
        
        for(int i=0; i<numCourses; i++)
            graph.add(new ArrayList<>());
        for(int[] prerequisite : prerequisites)
            graph.get(prerequisite[1]).add(prerequisite[0]);
        
        for(int i=0; i<numCourses; i++){
            if(! visited[i]){
                if(hasCycle(i))
                    return new int[]{};
            }
        }
        
        for(int i=0; i<result.length; i++)
            result[i] = stack.pop();
        
        return result;
    }
    
    public boolean hasCycle(int node){
        visited[node] = true;
        recStack[node] = true;
        for(int neighbour : graph.get(node)){
            if(! visited[neighbour]){
                if(hasCycle(neighbour))
                    return true;
            }
            else if(recStack[neighbour] == true)
                return true;
        }
        
        recStack[node] = false;
        stack.push(node);
        return false;
    }
}