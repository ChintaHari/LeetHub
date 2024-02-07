class Solution {
    Set<Integer> restrictedNodes = new HashSet<>();
    Map<Integer, List<Integer>> graph = new HashMap<>();
    int reachableNodes = 0;
    Set<Integer> visited = new HashSet<>();
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        for(int i=0; i<n; i++)
            graph.put(i, new ArrayList<>());
        for(int[] edge : edges){
            int x = edge[0], y = edge[1];
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        
        restrictedNodes = Arrays.stream(restricted).boxed().collect(Collectors.toSet());
        reachableNodes = 1;
        dfs(0);
       
        return reachableNodes;
    }
    
    public void dfs(int node){
        visited.add(node);
        for(int neighbour : graph.get(node)){
            if(! visited.contains(neighbour)){
                if(! restrictedNodes.contains(neighbour)){
                    reachableNodes ++;
                    dfs(neighbour);
                }
            }
        }
    }
}