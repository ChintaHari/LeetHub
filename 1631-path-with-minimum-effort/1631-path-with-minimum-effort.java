class State{
    int row;
    int col;
    State (int row, int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {
    int rows=0, cols=0;
    boolean visited[][];
    Queue<State> queue;
    int[][] dirs = new int[][]{{1,0}, {-1,0}, {0,-1}, {0,1}};
    public int minimumEffortPath(int[][] heights) {
        rows = heights.length;
        cols = heights[0].length;
        int left = 0;
        int right = Arrays.stream(heights).flatMapToInt(Arrays::stream).max().getAsInt();
        
        while(left <= right){
            int mid = left + (right - left)/2;
            if(checkIfPathExistsWithEffortLessThanEquals(mid, heights))
                right = mid - 1;
            else
                left = mid + 1;
        }
        return left;
    }
    
    public boolean checkIfPathExistsWithEffortLessThanEquals(int effort, int[][] heights){
        queue = new LinkedList<>();
        visited = new boolean[rows][cols];
        queue.offer(new State(0,0));
        visited[0][0] = true;
        
        while(!queue.isEmpty()){
            State state = queue.poll();
            int currRow = state.row, currCol = state.col;
            if(currRow == rows - 1 && currCol == cols - 1)
                return true;
            for(int[] dir : dirs){
                int nextRow = currRow + dir[0];
                int nextCol = currCol + dir[1];
                
                if(nextRow>=0 && nextRow < rows 
                   && nextCol>=0 && nextCol < cols
                   && !visited[nextRow][nextCol]){
                    if(Math.abs(heights[nextRow][nextCol] - heights[currRow][currCol]) <= effort){
                        visited[nextRow][nextCol] = true;
                        queue.offer(new State(nextRow, nextCol));
                    }
                }
            }
        }
        return false;
        
    }
}