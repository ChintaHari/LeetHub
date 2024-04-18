class Solution {
    int perimeter = 0;
    int[][] dirs = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};
    int[][] grid;
    int rows=0, cols=0;
    public int islandPerimeter(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        
        this.grid = grid;
        
        for(int row = 0; row < rows; row++){
            for(int col=0; col < cols; col++){
                if(grid[row][col] == 1)
                    dfs(row, col);
            }
        }
        return perimeter;
    }
    
    public void dfs(int row, int col){
        grid[row][col] = -1;
        
        for(int[] dir : dirs){
            int nextRow = row + dir[0];
            int nextCol = col + dir[1];
            
            if(nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols || grid[nextRow][nextCol] == 0)
                perimeter++;
            else if(grid[nextRow][nextCol] == 1)
                dfs(nextRow, nextCol);
        }
    }
}