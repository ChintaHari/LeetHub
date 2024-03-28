class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid2.length, n = grid2[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1 && !visited[i][j]) {
                    if (dfs(grid1, grid2, visited, i, j)) {
                        count++; 
                    }
                }
            }
        }
        
        return count;
    }
    
    private boolean dfs(int[][] grid1, int[][] grid2, boolean[][] visited, int i, int j) {
        if (i < 0 || i >= grid2.length || j < 0 || j >= grid2[0].length || grid2[i][j] == 0 || visited[i][j]) 
            return true;
        
        visited[i][j] = true;
        boolean result = true;
        
        if (grid1[i][j] == 0) 
            result = false;

        result &= dfs(grid1, grid2, visited, i + 1, j);
        result &= dfs(grid1, grid2, visited, i - 1, j);
        result &= dfs(grid1, grid2, visited, i, j + 1);
        result &= dfs(grid1, grid2, visited, i, j - 1);
        
        return result;
    }
}
