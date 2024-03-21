class Solution {
    int[][] memo, matrix;
    int rows, cols;
    int longestPath = 0;
    int[][] dirs = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};
    public int longestIncreasingPath(int[][] matrix) {
        rows = matrix.length;
        cols = matrix[0].length;
        this.matrix = matrix;
        
        memo = new int[rows][cols];
        for(int row=0; row<rows; row++){
            for(int col=0; col<cols; col++){
                longestPath = Math.max(longestPath, findLongestPath(row, col));
            }
        }
        
        return longestPath;
    }
    
    public int findLongestPath(int row, int col){
        if(memo[row][col] != 0)
            return memo[row][col];
        
        int currentMaxPathForThisRowAndCol = 1;
        for(int[] dir : dirs){
            int nextRow = row + dir[0];
            int nextCol = col + dir[1];
            
            if(nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols && matrix[nextRow][nextCol] > matrix[row][col]){
                int path = 1 + findLongestPath(nextRow, nextCol);
                currentMaxPathForThisRowAndCol = Math.max(currentMaxPathForThisRowAndCol, path);
            }
        }
        
        memo[row][col] = currentMaxPathForThisRowAndCol;
        return memo[row][col];
    }
}