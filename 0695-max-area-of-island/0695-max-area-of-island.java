class Solution {
    boolean[][] visited;
    int rows=0, cols=0;
    int maxArea = Integer.MIN_VALUE;
    int currArea = 0;
    int[][] grid;
    int[][] dirs = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};
    public int maxAreaOfIsland(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        this.grid = grid;
        
        visited = new boolean[rows][cols];
        
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(! visited[i][j]){
                    currArea = 0;
                    if(grid[i][j] == 1){
                        currArea++;
                        dfs(i,j);
                    }
                }
            }
        }
        return maxArea == Integer.MIN_VALUE ? 0 : maxArea;
    }
    
    public void dfs(int row, int col){
        visited[row][col] = true;
        for(int[] dir : dirs){
            int nextRow = row + dir[0], nextCol = col + dir[1];
            if(nextRow >= 0 && nextRow < rows && nextCol >=0 
               && nextCol < cols && grid[nextRow][nextCol] == 1
               && !visited[nextRow][nextCol]){
                currArea ++;
                dfs(nextRow, nextCol);
            }
        }
        maxArea = Math.max(maxArea, currArea);
    }
}