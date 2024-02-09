class Solution {
    boolean[][] visited;
    Queue<int[]> queue = new LinkedList<>();
    int rows=0, cols=0;
    int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    public int nearestExit(char[][] maze, int[] entrance) {
        rows = maze.length;
        cols = maze[0].length;
        visited = new boolean[rows][cols];
        int startRow = entrance[0], startCol = entrance[1];
        visited[startRow][startCol] = true;
        queue.offer(new int[]{startRow, startCol, 0});
        
        while(!queue.isEmpty()){
            int[] state = queue.poll();
            int currRow = state[0], currCol = state[1], steps = state[2];
           
            for(int[] dir: dirs){
                int nextRow = currRow + dir[0], nextCol = currCol + dir[1];
                if(valid(nextRow, nextCol, maze)){
                     if(nextRow == 0 || nextRow == rows - 1 || nextCol ==0 || nextCol == cols-1)
                            return steps+1;
                    visited[nextRow][nextCol] = true;
                    queue.offer(new int[]{nextRow, nextCol, steps+1});
                }
            }
        }
        return -1;
       
    }
    
    public boolean valid(int nextRow, int nextCol, char[][] maze){
        return nextRow >=0 && nextRow < rows && nextCol >= 0 
            && nextCol < cols && !visited[nextRow][nextCol]
            && maze[nextRow][nextCol] == '.';
    }
}