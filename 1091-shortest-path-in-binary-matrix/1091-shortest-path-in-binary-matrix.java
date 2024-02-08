class State{
    int row, col, steps;
    State(int row, int col, int steps){
        this.row = row;
        this.col = col;
        this.steps = steps;
    }
}
class Solution {
    Queue<State> queue = new LinkedList<>();
    boolean[][] visited;
    int rows=0, cols=0;
    int[][] dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1},{1,1},{1,-1},{-1,-1},{-1,1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1)
            return -1;
        rows = grid.length;
        cols = grid[0].length;
        
        visited = new boolean[rows][cols];
        visited[0][0] = true;
        queue.offer(new State(0,0,1));
        
        while(! queue.isEmpty()){
            State state = queue.poll();
            int row = state.row, col = state.col, steps = state.steps;
            if(row == rows-1 && col == cols-1)
                return steps;
            for(int[] dir: dirs){
                int nextRow = row + dir[0], nextCol = col + dir[1];
                if(valid(nextRow, nextCol, grid)){
                    visited[nextRow][nextCol] = true;
                    queue.offer(new State(nextRow, nextCol, steps+1));
                }
            }
        }
        return -1;
    }
    
    public boolean valid(int nextRow, int nextCol, int[][] grid){
        return nextRow >=0 && nextRow < rows && nextCol >=0 && nextCol < cols
            && !visited[nextRow][nextCol] && grid[nextRow][nextCol] == 0;
    }
}