class State{
    int row, col, height;
    State(int row, int col, int height){
        this.row = row;
        this.col = col;
        this.height = height;
    }
}
class Solution {
    public int swimInWater(int[][] grid) {
        PriorityQueue<State> queue = new PriorityQueue<>((a,b) -> (a.height - b.height));
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int[][] dirs = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};
        
        queue.offer(new State(0, 0, grid[0][0]));
        visited[0][0] = true;
        
        
        while(! queue.isEmpty()){
            State currentState = queue.poll();
            int currentRow = currentState.row, currentCol = currentState.col, currentHeight = currentState.height;
            
            if(currentRow == rows -1 && currentCol == cols - 1)
                return currentHeight;
            
            visited[currentRow][currentCol] = true;
            for(int[] dir : dirs){
                int nextRow = currentRow + dir[0];
                int nextCol = currentCol + dir[1];
                
                if(nextRow >= 0 && nextRow < rows && nextCol >=0 && nextCol<cols && !visited[nextRow][nextCol])
                    queue.offer(new State(nextRow, nextCol, Math.max(currentHeight, grid[nextRow][nextCol])));
            }
            
        }
        
        return -1;
    }
}