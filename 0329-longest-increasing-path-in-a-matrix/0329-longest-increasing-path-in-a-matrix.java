class Solution {
    int[][] matrix, memo;
    int rows = 0, cols=0;
    int longestPath = 0;
    int[][] dirs = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};
    public int longestIncreasingPath(int[][] matrix) {
        rows = matrix.length;
        cols = matrix[0].length;
        this.matrix = matrix;
        memo = new int[rows][cols];
        
        for(int row=0; row < rows; row++){
            for(int col=0; col<cols; col++){
                longestPath = Math.max(longestPath, findMaxPathForThisRowAndColumn(row, col));
            }
        }
        
        return longestPath;
    }
    
    public int findMaxPathForThisRowAndColumn(int row, int col){
        if(memo[row][col] != 0)
            return memo[row][col];
        
        int currentMaxPathForThisRowAndColumn = 1;
        for(int[] dir : dirs){
            int nextRow = row + dir[0];
            int nextCol = col + dir[1];
            
            if(nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols && matrix[nextRow][nextCol] > matrix[row][col]){
                int path = 1 + findMaxPathForThisRowAndColumn(nextRow, nextCol);
                currentMaxPathForThisRowAndColumn = Math.max(currentMaxPathForThisRowAndColumn, path);
            }
        }
        memo[row][col] = currentMaxPathForThisRowAndColumn;
        return memo[row][col];
    }
}