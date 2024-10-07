class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        int[][] dirs = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};
        int rows = image.length;
        int cols = image[0].length;
        
        int originalColor = image[sr][sc];
        
        if(color == originalColor)
            return image;
        
        Queue<int[]> queue = new LinkedList<>();
        
        image[sr][sc] = color;
        
        queue.offer(new int[]{sr, sc});
        
        while(!queue.isEmpty()){
            int[] currentRowAndCol = queue.poll();
            int currentRow = currentRowAndCol[0];
            int currentCol = currentRowAndCol[1];
            
            for(int[] dir : dirs){
                int nextRow = currentRow + dir[0];
                int nextCol = currentCol + dir[1];
                
                if(nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols
                  && image[nextRow][nextCol] == originalColor){
                    
                    image[nextRow][nextCol] = color;
                    queue.offer(new int[]{nextRow, nextCol});
                }
            }
        }
        return image;
    }
}