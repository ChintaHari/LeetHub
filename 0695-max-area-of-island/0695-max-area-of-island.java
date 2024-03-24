class Solution {
    int maxArea = Integer.MIN_VALUE;
    int[][] grid;
    int rows = 0, cols = 0, currArea = 0;
    boolean[][] visited;
    int[][] dirs = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};
    public int maxAreaOfIsland(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        visited = new boolean[rows][cols];
        this.grid = grid;
        
        for(int row=0; row<rows; row++){
            for(int col=0; col<cols; col++){
                currArea = 0;
                if(!visited[row][col] && grid[row][col] == 1){
                    currArea++;
                    dfs(row, col);
                }
            }
        }
        return maxArea == Integer.MIN_VALUE ? 0 : maxArea;
    }
    
    public void dfs(int row, int col){
        visited[row][col] = true;
        for(int[] dir : dirs){
            int nextRow = row + dir[0];
            int nextCol = col + dir[1];
            
            if(nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols
              && !visited[nextRow][nextCol] && grid[nextRow][nextCol] == 1){
                currArea++;
                dfs(nextRow, nextCol);
            }
        }
        maxArea = Math.max(maxArea, currArea);
    }
}