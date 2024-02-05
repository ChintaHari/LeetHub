class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int rows = maze.length;
        int cols = maze[0].length;
        int[][] dirs = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
        Queue<int[]> queue= new LinkedList<>();
        int startRow = entrance[0], startCol = entrance[1];
        maze[startRow][startCol] = '+';
        queue.add(new int[]{startRow, startCol, 0});
        while(! queue.isEmpty()){
            int[] remove = queue.remove();
            int currRow = remove[0], currCol = remove[1], currDistance = remove[2];
            for(int[] dir : dirs){
                int nextRow = currRow + dir[0];
                int nextCol = currCol + dir[1];
                if(nextRow >=0 && nextRow < rows && nextCol >=0 && nextCol < cols && maze[nextRow][nextCol]=='.'){
                    if(nextRow ==0 || nextRow == rows-1 || nextCol ==0 || nextCol == cols-1)
                        return currDistance + 1;
                    maze[nextRow][nextCol] = '+';
                    queue.add(new int[]{nextRow, nextCol, currDistance + 1});
                }
            }
        }
        return -1;
    }
}