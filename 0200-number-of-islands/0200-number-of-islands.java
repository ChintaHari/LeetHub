class Solution {
    int m, n;
    boolean visited[][];
    int dirs[][] = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        int islands = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    islands++;
                    dfs(i, j, grid);
                }
            }
        }
        return islands;
    }

    public void dfs(int i, int j, char[][] grid){
        visited[i][j] = true;
        for(int[] dir: dirs){
            int nextRow = i + dir[0];
            int nextCol = j + dir[1];

            if(nextRow >=0 && nextRow < m && nextCol >=0 && nextCol < n
             && grid[nextRow][nextCol] == '1' && !visited[nextRow][nextCol]){
                 visited[nextRow][nextCol] = true;
                 dfs(nextRow, nextCol, grid); 
             }
        }
        
//         Stack<Integer> rowStack = new Stack<>();
//         Stack<Integer> colStack = new Stack<>();
//         rowStack.push(i);   colStack.push(j);
//         visited[i][j] = true;
//         while(!rowStack.isEmpty()){
//             int currRow = rowStack.pop();
//             int currCol = colStack.pop();
            
//             for(int[] dir: dirs){
//                 int nextRow = currRow + dir[0];
//                 int nextCol = currCol + dir[1];
//                 if(nextRow >=0 && nextRow < m && nextCol >=0 && nextCol < n
//                  && grid[nextRow][nextCol] == '1' && !visited[nextRow][nextCol]){
//                     visited[nextRow][nextCol] = true;
//                     rowStack.push(nextRow);
//                     colStack.push(nextCol);
//                 }
//             }
//         }
        
    }
}