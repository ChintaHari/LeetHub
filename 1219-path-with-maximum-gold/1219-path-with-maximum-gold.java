class Solution {
    int rows = 0, cols=0;
    int[][] grid;
    boolean[][] visited;
    int[][] dirs = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};
    public int getMaximumGold(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        visited = new boolean[rows][cols];
        this.grid = grid;
        
        int maxGold = 0;
        
        for(int row=0; row < rows; row++){
            for(int col=0; col < cols; col++){
                if(grid[row][col] != 0 && !visited[row][col])
                    maxGold = Math.max(maxGold, backtrack(row, col));
            }
        }
        return maxGold;
    }
    
    public int backtrack(int row, int col){
        visited[row][col] = true;
        int maxGoldForTheCurrentPath = 0;
        
        for(int[] dir : dirs){
            int nextRow = row + dir[0];
            int nextCol = col + dir[1];
            
            if(nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols
               && !visited[nextRow][nextCol] && grid[nextRow][nextCol] != 0)
                    maxGoldForTheCurrentPath = Math.max(maxGoldForTheCurrentPath, backtrack(nextRow, nextCol));
                 
        }
    
        visited[row][col] = false;
        return grid[row][col] + maxGoldForTheCurrentPath;
        
    }
}