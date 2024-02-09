class Solution {
    boolean[][] visited;
    Map<Integer, Map<Integer, List<Integer>>> graph = new HashMap<>();
    Queue<int[]> queue = new LinkedList<>();
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int red=0, blue=1;
        visited = new boolean[n][2];
        int[] ans = new int[n];
        Arrays.fill(ans, Integer.MAX_VALUE);
        
        for(int i=0; i<2;i++)
            graph.put(i, new HashMap<>());
        
        buildGraph(red, redEdges, n);
        buildGraph(blue, blueEdges, n);
        
        queue.offer(new int[]{0,0,red});
        queue.offer(new int[]{0,0,blue});
        
        visited[0][red] = true;
        visited[0][blue] = true;
        
        while(! queue.isEmpty()){
            int[] state = queue.poll();
            int node = state[0], steps = state[1], color = state[2];
            ans[node] = Math.min(ans[node], steps);
            for(int neighbour : graph.get(color).get(node)){
                if(! visited[neighbour][1-color]){
                    visited[neighbour][1-color] = true;
                    queue.offer(new int[]{neighbour, steps+1, 1-color});
                }
            }
            
        }
        
        for(int i=0; i<ans.length; i++)
            if(ans[i] == Integer.MAX_VALUE)
                ans[i] = -1;
        return ans;
    }
    
    
    public void buildGraph(int color, int[][] edges, int n){
        for(int i=0; i<n; i++)
            graph.get(color).put(i, new ArrayList<>());
        
        for(int[] edge: edges){
            int x = edge[0], y = edge[1];
            graph.get(color).get(x).add(y);
        }
    }
}