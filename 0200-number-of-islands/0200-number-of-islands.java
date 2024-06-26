class Solution {
    char[][] grid;
    boolean[][] visited;
    int rows, cols;
    int[][] dirs = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};
    int islands = 0;
    public int numIslands(char[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        
        visited = new boolean[rows][cols];
        this.grid = grid;
        
        for(int row = 0; row < rows; row++){
            for(int col=0; col < cols; col++){
                if(grid[row][col] == '1' && !visited[row][col]){
                    islands++;
                    dfs(row, col);
                }
            }
        }
        return islands;
    }
    
    public void dfs(int row, int col){
        visited[row][col] = true;
        
        for(int[] dir : dirs){
            int nextRow = row + dir[0];
            int nextCol = col + dir[1];
            
            if(nextRow >= 0 && nextRow < rows && nextCol >=0 && nextCol < cols 
               && !visited[nextRow][nextCol] && grid[nextRow][nextCol] == '1')
                dfs(nextRow, nextCol);
        }
    }
}