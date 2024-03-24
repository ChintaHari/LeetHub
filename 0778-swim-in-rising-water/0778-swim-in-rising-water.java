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
        int rows = grid.length, cols = grid[0].length;
        int[][] dirs = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};
        boolean[][] visited = new boolean[rows][cols];
        
        PriorityQueue<State> queue = new PriorityQueue<>((a,b) -> (a.height - b.height));
        queue.offer(new State(0,0, grid[0][0]));
        
        while(! queue.isEmpty()){
            State state = queue.poll();
            int currentRow = state.row, currentCol = state.col, currentHeight = state.height;
            
            if(currentRow == rows - 1 && currentCol == cols - 1)
                return currentHeight;
            
            visited[currentRow][currentCol] = true;
            
            for(int[] dir : dirs){
                int nextRow = currentRow + dir[0];
                int nextCol = currentCol + dir[1];
                if(nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols && visited[nextRow][nextCol] == false){
                    queue.offer(new State(nextRow, nextCol, Math.max(currentHeight, grid[nextRow][nextCol])));
                }
            }
            
        }
        
        return -1;
        
    }
}