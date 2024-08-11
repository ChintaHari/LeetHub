class Solution {
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    int rows=0, cols=0;
    boolean[][] visited;
    public int minDays(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;

        if (countIslands(grid) != 1) 
            return 0;
        
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 0)
                    continue; 

                grid[row][col] = 0;
                int newIslandCount = countIslands(grid);

                if (newIslandCount != 1) return 1;

                grid[row][col] = 1;
            }
        }

        return 2;
    }

    private int countIslands(int[][] grid) {
        visited = new boolean[rows][cols];
        int islandCount = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (!visited[row][col] && grid[row][col] == 1) {
                    exploreIsland(grid, row, col);
                    islandCount++;
                }
            }
        }
        return islandCount;
    }

    private void exploreIsland(int[][] grid,int row,int col) {
        visited[row][col] = true;
        for (int[] direction : dirs) {
            int nextRow = row + direction[0];
            int nextCol = col + direction[1];
            if (nextRow >= 0 && nextCol >= 0 && nextRow < rows && nextCol < cols
                && grid[nextRow][nextCol] == 1 && !visited[nextRow][nextCol]) 
                exploreIsland(grid, nextRow, nextCol);
        }
    }

}