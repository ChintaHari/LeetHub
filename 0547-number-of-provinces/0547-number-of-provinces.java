class Solution {
    boolean[] visited;
    int provinces = 0;
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        visited = new boolean[n];
        for(int i=0; i<n; i++){
            if(! visited[i]){
                provinces++;
                dfs(i, isConnected);
            }
        }
       return provinces;
        
    }
    public void dfs(int node, int[][] isConnected){
        visited[node] = true;
        for(int i=0; i<isConnected.length; i++)
            if(isConnected[node][i] ==1 && !visited[i])
                dfs(i, isConnected);
    }
}