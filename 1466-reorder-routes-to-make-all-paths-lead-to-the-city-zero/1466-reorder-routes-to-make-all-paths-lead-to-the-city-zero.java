class Solution {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    Set<Integer> visited = new HashSet<Integer>();
    Set<String> roads = new HashSet<>();
    int swaps=0;
    public int minReorder(int n, int[][] connections) {
        for(int[] connection: connections){
            int x = connection[0], y = connection[1];
            graph.computeIfAbsent(x, k -> new ArrayList<>()).add(y);
            graph.computeIfAbsent(y, k -> new ArrayList<>()).add(x);
            roads.add(convertToString(x, y));
        }
        
        dfs(0);
        return swaps;
    }
    
    public void dfs(int node){
        visited.add(node);
        for(int neighbour: graph.get(node)){
            if(! visited.contains(neighbour)){
                if(roads.contains(convertToString(node, neighbour)))
                    swaps++;
            dfs(neighbour);
            }
            
         }
    }
    
    public String convertToString(int x, int y){
        return String.valueOf(x) + "," + String.valueOf(y);
    }
}