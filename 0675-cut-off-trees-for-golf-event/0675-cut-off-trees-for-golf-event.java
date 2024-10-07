class Solution {
    List<List<Integer>> forest;
    int[][] dirs = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};
    int rows = 0, cols = 0;
    public int cutOffTree(List<List<Integer>> forest) {
        
        List<int[]> trees = new ArrayList<>();
        rows = forest.size();
        cols = forest.get(0).size();
        this.forest = forest;
        
        for(int row=0; row<rows; row++){
            for(int col=0; col<cols; col++){
                int treeHeight = forest.get(row).get(col);
                if(treeHeight > 1)
                    trees.add(new int[]{treeHeight, row, col});
            }
        }
        
        Collections.sort(trees, (a,b) -> a[0] - b[0]);
        
        int totalSteps = 0;
        int startRow = 0, startCol = 0;
        
        for(int[] tree : trees){
            int targetRow = tree[1];
            int targetCol = tree[2];
            
            int steps = bfs(startRow, startCol, targetRow, targetCol);
            
            if(steps == -1)
                return -1;
            
            totalSteps = totalSteps + steps;
            startRow = targetRow;
            startCol = targetCol;
        }
        return totalSteps;
    }
    
    public int bfs(int startRow, int startCol, int targetRow, int targetCol){
        if(startRow == targetRow && startCol == targetCol)
            return 0;
        
        int steps = 0;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];
        
        queue.offer(new int[]{startRow, startCol});
        
        visited[startRow][startCol] = true;
        
        while(!queue.isEmpty()){
            steps++;
            int size = queue.size();
            
            for(int i=0; i<size; i++){
                int[] current = queue.poll();
                int currentRow = current[0];
                int currentCol = current[1];
                
                for(int[] dir : dirs){
                    int nextRow = currentRow + dir[0];
                    int nextCol = currentCol + dir[1];
                    
                    if(nextRow >= 0 && nextRow < rows && nextCol >=0 && nextCol < cols
                      && !visited[nextRow][nextCol] && forest.get(nextRow).get(nextCol) != 0){
                        if(nextRow == targetRow && nextCol == targetCol)
                            return steps;
                        
                        visited[nextRow][nextCol] = true;
                        queue.offer(new int[]{nextRow, nextCol});
                    }
                }
            }
        }
        return -1;
    }
}