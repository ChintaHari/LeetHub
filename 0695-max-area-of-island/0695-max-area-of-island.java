class Solution {
    Set<String> visited = new HashSet<>();
    int max = Integer.MIN_VALUE;
    int currArea = 0;
    int[][] dirs = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
    int rows = 0, cols = 0;
    public int maxAreaOfIsland(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(! visited.contains(convertToString(i,j))){
                    currArea = 0;
                    if(grid[i][j] == 1){
                        currArea ++;
                        dfs(i, j, grid);
                    }
                }
            }
        }
        return max == Integer.MIN_VALUE ? 0 : max;
        
    }
    
    public void dfs(int startRow, int startCol, int[][] grid){
        visited.add(convertToString(startRow, startCol));
        for(int[] dir: dirs){
            int nextRow = startRow + dir[0], nextCol = startCol + dir[1];
            if(nextRow >=0 && nextRow < rows && nextCol >=0 && nextCol < cols
              && grid[nextRow][nextCol]==1 && !visited.contains(convertToString(nextRow, nextCol))){
                currArea++;
                dfs(nextRow, nextCol, grid);
            }
        }
        max = Math.max(max, currArea);
    }
    
    public String convertToString(int x, int y){
        return String.valueOf(x) + "," + String.valueOf(y);
    }
}