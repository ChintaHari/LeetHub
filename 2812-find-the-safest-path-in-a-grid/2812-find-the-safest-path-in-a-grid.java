class Solution {
    int rows=0, cols=0, grid_size = 0;
    int dirs[][] = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};
    int[][] safenessMatrix;
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        rows = cols = grid_size = grid.size();
        safenessMatrix = new int[rows][cols];
        Queue<int[]> queue = new LinkedList<>();
        
        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                if(grid.get(row).get(col) == 1){
                    queue.offer(new int[]{row, col});
                    safenessMatrix[row][col] = 0; // Indicating that this is a theif
                }
                else
                    safenessMatrix[row][col] = -1;
            }
        }
        
        while(! queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                int[] state = queue.poll();
                int currentRow = state[0];
                int currentCol = state[1];
                for(int[] dir : dirs){
                    int nextRow = currentRow + dir[0];
                    int nextCol = currentCol + dir[1];
                    
                    if(nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols && safenessMatrix[nextRow][nextCol] == -1){
                        safenessMatrix[nextRow][nextCol] = safenessMatrix[currentRow][currentCol] + 1;
                        queue.offer(new int[]{nextRow, nextCol});
                    }
                }
            }
        }
        
        int start = 0, end = 0, res = -1;
        
        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                end = Math.max(end, safenessMatrix[row][col]);
            }
        }
        
        while(start <= end){
            int mid = start + (end - start)/2;
            if(isValidSafeness(mid)){
                res = mid;
                start = mid + 1;
            }
            else
                end = mid - 1;
        }
        
        return res;
        
    }
    
    public boolean isValidSafeness(int minSafenessValue){
        if(safenessMatrix[0][0] < minSafenessValue || safenessMatrix[grid_size-1][grid_size-1] < minSafenessValue)
            return false;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        boolean[][] visited = new boolean[grid_size][grid_size];
        visited[0][0] = true;
        
        while(!queue.isEmpty()){
            int[] state = queue.poll();
            int currentRow = state[0];
            int currentCol = state[1];
            
            if(currentRow == grid_size - 1 && currentCol == grid_size - 1)
                return true;
            
            for(int[] dir : dirs){
                int nextRow = currentRow + dir[0];
                int nextCol = currentCol + dir[1];
                
                if(nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols
                   && !visited[nextRow][nextCol] && safenessMatrix[nextRow][nextCol] >= minSafenessValue){
                    visited[nextRow][nextCol] = true;
                    queue.offer(new int[]{nextRow, nextCol});
                }
            }
        }
        
        return false;
        
    }
}