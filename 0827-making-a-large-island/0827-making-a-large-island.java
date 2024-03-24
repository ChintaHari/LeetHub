class Solution {
    int[][] grid;
    int rows, cols;
    int maxSizeOfIsland = 0;
    boolean hasZero = false;
    int numOfIslands = 0;
    int islandID = 2;
    int[][] dirs = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};
    HashMap<Integer, Integer> islandIDtoSizeMap = new HashMap<>();
    public int largestIsland(int[][] grid) {
        this.grid = grid;
        rows = grid.length;
        cols = grid[0].length;
        
        for(int row=0; row < rows; row++){
            for(int col=0; col < cols; col++){
                if(grid[row][col] == 1){
                    int size = dfs(row, col, islandID); //this is the start of an island, so find the size of this island through DFS
                    numOfIslands++;
                    islandIDtoSizeMap.put(islandID, size);
                    maxSizeOfIsland = Math.max(maxSizeOfIsland, size);
                    islandID++;
                }
            }
        }
        
        for(int row=0; row < rows; row++){
            for(int col=0; col<cols; col++){
                if(grid[row][col] == 0){
                    hasZero = true;
                    Set<Integer> neighbouringIslandIDs = new HashSet<>();
                    for(int[] dir : dirs){
                        int nextRow = row + dir[0];
                        int nextCol = col + dir[1];
                        
                        if(nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols && grid[nextRow][nextCol] >= 1)
                            neighbouringIslandIDs.add(grid[nextRow][nextCol]);
                        
                        int size = 1;
                        
                        for(int id : neighbouringIslandIDs)
                            size = size + islandIDtoSizeMap.get(id);
                        
                         maxSizeOfIsland = Math.max(maxSizeOfIsland, size);
                    }
                }
            }
        }
        
        return hasZero ? maxSizeOfIsland : rows * cols;
    }
    
    
    public int dfs(int row, int col, int islandID){
        grid[row][col] = islandID;
        int size = 1;
        for(int[] dir : dirs){
            int nextRow = row + dir[0];
            int nextCol = col + dir[1];
            if(nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols && grid[nextRow][nextCol] == 1)
                size = size + dfs(nextRow, nextCol, islandID);
        }
        return size;
    }
}