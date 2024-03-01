class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> curr = new ArrayList<>();
    int n;
    HashMap<Integer, List<Integer>> graph = new HashMap<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        n = graph.length;
        curr.add(0);
        backtrack(0, graph);
        return result;
    }
    
    public void backtrack(int node, int[][] graph){
        if(node == n-1){
            result.add(new ArrayList<>(curr));
            return;
        }
        
        for(int neighbour : graph[node]){
            curr.add(neighbour);
            backtrack(neighbour, graph);
            curr.remove(curr.size() - 1);
        }
    }
}