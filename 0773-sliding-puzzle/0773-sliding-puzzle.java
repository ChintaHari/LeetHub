class Solution {
    int minStep = Integer.MAX_VALUE;
    int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public int slidingPuzzle(int[][] board) {
        for(int i=0; i<board.length;i++){
            for(int j=0; j<board[0].length;j++){
                if(board[i][j] == 0){
                    dfs(board, 0, new int[]{-1, -1}, new int[]{i, j});
                    break;
                }
            }
        }
        return minStep == Integer.MAX_VALUE ? -1: minStep;
    }


    private void dfs(int[][] board, int step, int[] prev, int[] curr){
        if(step > 20)
            return;

        if(isValid(board)){
            minStep = Math.min(minStep, step);
            return;
        }
     
        int currX = curr[0], currY = curr[1];
        for(int[] dir:dirs){
            int dirX = dir[0], dirY = dir[1];
            int newX = dirX + currX, newY = dirY + currY;
            if(newX < 0 || newY < 0 || newX >= board.length || newY >= board[0].length ||
            (prev[0] == newX && prev[1] == newY)) 
                continue;
            swapPieces(board, curr, new int[]{newX, newY});
            dfs(board, step+1, curr, new int[]{newX, newY});
            swapPieces(board, new int[]{newX, newY}, curr);
        }
    }

    private void swapPieces(int[][] board, int[] first, int[] second){
        int tmp = board[first[0]][first[1]];
        board[first[0]][first[1]] = board[second[0]][second[1]];
        board[second[0]][second[1]] = tmp;
    }

    private boolean isValid(int[][] board){
        int val = 1;
        for(int row=0; row<board.length; row++){
            for(int col=0; col<board[0].length; col++){
                if(row == 1 && col == 2) return board[row][col] == 0;
                if(board[row][col] != val) return false;
                val++;
            }
        }
        return true;
    }
}