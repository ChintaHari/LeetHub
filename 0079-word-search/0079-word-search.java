class Solution {
    int rows =0, cols=0, currWordLength=0;
    String target;
    boolean[][] visited;
    int[][] dirs = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};
    public boolean exist(char[][] board, String word) {
        target = word;
        rows = board.length;
        cols = board[0].length;
        visited = new boolean[rows][cols];
        for(int row = 0; row < rows; row++){
            for(int col=0; col < cols; col++){
                if(board[row][col] == word.charAt(0)){
                    visited[row][col] = true;
                    if(backtrack(row, col, board, currWordLength + 1))
                        return true;
                }
            }
        }
    return false;
    }

    public boolean backtrack(int row, int col, char[][]board, int currWordLength){
        if(currWordLength == target.length())
            return true;
        for(int[] dir : dirs){
            int nextRow = row + dir[0];
            int nextCol = col + dir[1];
            if(nextRow >= 0 && nextRow < rows && nextCol >=0 &&
             nextCol < cols && !visited[nextRow][nextCol]){
                 if(board[nextRow][nextCol] == target.charAt(currWordLength)){
                     visited[nextRow][nextCol] = true;
                     if(backtrack(nextRow, nextCol, board, currWordLength + 1))
                        return true;
                     
                 }
             }
        }
        visited[row][col] = false;
        return false;
    }
}