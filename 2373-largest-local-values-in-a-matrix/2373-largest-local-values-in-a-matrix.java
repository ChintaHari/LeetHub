class Solution {
    int[][] grid;
    public int[][] largestLocal(int[][] grid) {
        this.grid = grid;
        int n = grid.length;
        int result[][] = new int[n-2][n-2];
        
        for(int i=0; i<n-2; i++)
            for(int j=0; j<n-2; j++)
                result[i][j] = findMaxValue(i, j);
        
        return result;
    }
    
    public int findMaxValue(int i, int j){
        int max = 0;
        for(int m=i; m<i+3; m++)
            for(int n=j; n<j+3; n++)
                max = Math.max(max, grid[m][n]);
        return max;
    }
}