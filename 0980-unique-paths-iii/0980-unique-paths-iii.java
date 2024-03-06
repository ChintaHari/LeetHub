class Solution {
    boolean[][] visited;
    int rows =0, cols=0, startRow=0, startCol=0, totalSols=0, actualCountOfEmptySquares=0;
    int[][] dirs = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};
    public int uniquePathsIII(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        visited = new boolean[rows][cols];
        
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j] == 0)
                    actualCountOfEmptySquares++;
                if(grid[i][j] == 1){
                    startRow = i;
                    startCol = j;
                    actualCountOfEmptySquares++;
                }
            }
        }
        
        visited[startRow][startCol] = true;
        backtrack(grid, startRow, startCol, 0);
        return totalSols;
    }
    
    public void backtrack(int[][]grid, int row, int col, int currentCountOfEmptySquares){
        if(grid[row][col] == 2){
            if(currentCountOfEmptySquares == actualCountOfEmptySquares)
                totalSols ++;
            return;
        }
        
        for(int[] dir : dirs){
            int nextRow = row + dir[0], nextCol = col + dir[1];
            if(nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols 
               && !visited[nextRow][nextCol] && grid[nextRow][nextCol] != -1){
                visited[nextRow][nextCol] = true;
                backtrack(grid, nextRow, nextCol, currentCountOfEmptySquares + 1);
                visited[nextRow][nextCol] = false;
            }
        }
        
    }
}

