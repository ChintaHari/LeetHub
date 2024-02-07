class Solution {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        
        for(int[] edge: edges){
            int x = edge[0], y = edge[1];
            graph.computeIfAbsent(x, k->new ArrayList<>()).add(y);
            graph.computeIfAbsent(y, k->new ArrayList<>()).add(x);
        }
        return dfs(source, destination);
    }
    
    public boolean dfs(int source, int destination){
        if(source == destination)
            return true;
        visited.add(source);
        for(int neighbour: graph.get(source))
            if(!visited.contains(neighbour))
                if(dfs(neighbour, destination))
                    return true;
        return false;
    }
}