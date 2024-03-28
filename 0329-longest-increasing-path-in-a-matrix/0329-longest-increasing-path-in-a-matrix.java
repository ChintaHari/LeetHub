class Solution {
    int[][] memo, matrix;
    int rows, cols;
    int[][] dirs = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};
    int longestPath = Integer.MIN_VALUE;
    public int longestIncreasingPath(int[][] matrix) {
        rows = matrix.length;
        cols = matrix[0].length;
        
        memo = new int[rows][cols];
        this.matrix = matrix;
        
        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                longestPath = Math.max(longestPath, computeIncreasingPathForThisRowAndColumn(row, col));
            }
        }
        return longestPath;
    }
    
    public int computeIncreasingPathForThisRowAndColumn(int row, int col){
        if(memo[row][col] != 0)
            return memo[row][col];
        
        int currentPathForThisRowAndColumn = 1;
        for(int[] dir : dirs){
            int nextRow = row + dir[0];
            int nextCol = col + dir[1];
            
            if(nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols && matrix[nextRow][nextCol] > matrix[row][col]){
                int path = 1 + computeIncreasingPathForThisRowAndColumn(nextRow, nextCol);
                currentPathForThisRowAndColumn = Math.max(currentPathForThisRowAndColumn, path);
            }
        }
        
        memo[row][col] = currentPathForThisRowAndColumn;
        return currentPathForThisRowAndColumn;
    }
}