class Solution {
    int[][] land;
    boolean[][] visited;
    int rows, cols;
    int dirs[][] = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};
    List<int[]> result = new ArrayList<>();
    public int[][] findFarmland(int[][] land) {
        rows = land.length;
        cols = land[0].length;
        
        this.land = land;
        visited = new boolean[rows][cols];
        
        for(int row =0; row<rows; row++){
            for(int col=0; col < cols; col++){
                if(land[row][col] == 1 && !visited[row][col]){
                    int[] farmBoundary = new int[]{row, col, row, col};
                    dfs(row, col, farmBoundary);
                    result.add(new int[]{farmBoundary[0], farmBoundary[1],
                                        farmBoundary[2], farmBoundary[3]});
                }
            }
        }
        
        return result.toArray(new int[result.size()][]);
    }
    
    public void dfs(int row, int col, int[] farmBoundary){
        visited[row][col] = true;
        
        farmBoundary[0] = Math.min(farmBoundary[0], row);
        farmBoundary[1] = Math.min(farmBoundary[1], col);
        farmBoundary[2] = Math.max(farmBoundary[2], row);
        farmBoundary[3] = Math.max(farmBoundary[3], col);
        
        for(int[] dir : dirs){
            int nextRow = row + dir[0];
            int nextCol = col + dir[1];
            
            if(nextRow >= 0 && nextRow < rows && nextCol >=0 && nextCol < cols
              && land[nextRow][nextCol] == 1 && !visited[nextRow][nextCol])
                dfs(nextRow, nextCol, farmBoundary);
        }
    }
}