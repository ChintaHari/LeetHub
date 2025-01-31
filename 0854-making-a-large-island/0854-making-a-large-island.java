class Solution {
    int[][] grid;
    int rows = 0, cols=0;
    boolean[][] visited;
    int[][] dirs = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};
    Map<Integer, Integer> islandIDtoSizeMap = new HashMap<>();
    int islandID = 2, numberOfIslands = 0, maxIsland = 0;
    boolean hasZero = false;
    public int largestIsland(int[][] grid) {
        this.grid = grid;
        rows = grid.length;
        cols = grid[0].length;
        visited = new boolean[rows][cols];
        
        for(int row = 0; row < rows ; row++){
            for(int col = 0; col<cols; col++){
                if(grid[row][col] == 1){
                    int size = dfs(row, col, islandID);
                    numberOfIslands++;
                    islandIDtoSizeMap.put(islandID, size);
                    maxIsland = Math.max(maxIsland, size);
                    islandID++;;
                }
            }
        }
        
        for(int row=0; row<rows; row++){
            for(int col = 0; col<cols; col++){
                if(grid[row][col] == 0){
                    hasZero = true;
                    HashSet<Integer> set = new HashSet<>();
                    for(int[] dir : dirs){
                        int nextRow = row + dir[0];
                        int nextCol = col + dir[1];
                        if(nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols && grid[nextRow][nextCol] > 1)
                            set.add(grid[nextRow][nextCol]);
                    }
                    int size = 1;
                    for(int id : set)
                        size = size + islandIDtoSizeMap.get(id);
                    maxIsland = Math.max(maxIsland, size);

                }
            }
        }
        
        return hasZero ? maxIsland : rows * cols;
    }
    
    public int dfs(int row, int col, int islandID){
        visited[row][col] = true;
        grid[row][col] = islandID;
        int size = 1;
        
        for(int[] dir : dirs){
            int nextRow = row + dir[0];
            int nextCol = col + dir[1];
            
            if(nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols 
               && !visited[nextRow][nextCol] && grid[nextRow][nextCol] == 1){
                size = size + dfs(nextRow, nextCol, islandID);
            }
        }
        return size;
    }
}