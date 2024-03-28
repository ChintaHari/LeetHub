class Solution {
    int[][] grid1, grid2;
    int m, n;
    boolean[][] visited;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        m = grid2.length;
        n = grid2[0].length;
        visited = new boolean[m][n];
        
        this.grid1 = grid1;
        this.grid2 = grid2;
        int count = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1 && !visited[i][j]) {
                    if (dfs(i, j)) {
                        count++; 
                    }
                }
            }
        }
        
        return count;
    }
    
    private boolean dfs(int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid2[i][j] == 0 || visited[i][j]) 
            return true;
        
        visited[i][j] = true;
        boolean result = true;
        
        if (grid1[i][j] == 0) 
            result = false;

        result &= dfs(i + 1, j);
        result &= dfs(i - 1, j);
        result &= dfs(i, j + 1);
        result &= dfs(i, j - 1);
        
        return result;
    }
}
