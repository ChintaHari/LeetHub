class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length, target = n*n; 
        boolean[] visited = new boolean[target + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = true;
        int moves = 0;
        
        while(!queue.isEmpty()){
            int squareAtCurrentLevel = queue.size();
            for(int i=0; i<squareAtCurrentLevel; i++){
                int currSquare = queue.poll();
                if(currSquare == target)
                    return moves;
                for(int next = currSquare + 1; next <= Math.min(currSquare+6, target); next++){
                    int[] position = getPosition(next, n);
                    int row = position[0], col = position[1];
                    int destination = board[row][col] == -1 ? next : board[row][col];
                    
                    if(! visited[destination]){
                        visited[destination] = true;
                        queue.offer(destination);
                    }
                }
            }
            moves ++;
        }
        return -1;
    }
    
     private int[] getPosition(int next, int n) {
        int row = (next - 1) / n,col = (next - 1) % n;

        if (row % 2 == 1) 
            col = n - 1 - col;
    
        row = n - 1 - row;
        return new int[]{row, col};
    }
}
