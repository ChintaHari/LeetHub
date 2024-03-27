class Solution {
    int[][] memo;
    int rows, cols;
    int[][] matrix;
    int maxPath = 0;
    int [][] dirs = new int[][]{{0,1}, {1,0}, {-1, 0}, {0, -1}};
    public int longestIncreasingPath(int[][] matrix) {
        rows = matrix.length;
        cols = matrix[0].length;
        memo = new int[rows][cols];
        this.matrix = matrix;
        
        for(int row = 0; row < rows; row++){
            for(int col =0; col < cols; col++){
               maxPath = Math.max(maxPath, longestPathForThisCurrentRowAndCol(row, col));
            }
        }
        
        return maxPath;
    }
    
    public int longestPathForThisCurrentRowAndCol(int row, int col){
        if(memo[row][col] != 0)
            return memo[row][col];
        
        int currentMaxPathForThisCell = 1;
        for(int[] dir : dirs){
            int nextRow = row + dir[0];
            int nextCol = col + dir[1];
            
            if(nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols 
               && matrix[nextRow][nextCol] > matrix[row][col]){
                int path = 1 + longestPathForThisCurrentRowAndCol(nextRow, nextCol);
                currentMaxPathForThisCell = Math.max(currentMaxPathForThisCell, path);
            }
        }
        memo[row][col] = currentMaxPathForThisCell;
        return currentMaxPathForThisCell;
    }
}