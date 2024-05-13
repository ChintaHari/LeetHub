class Solution {
    public int matrixScore(int[][] grid) {
        int score = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        
        for(int row = 0; row < rows; row++){
           if(grid[row][0] == 0){
               for(int col=0; col < cols; col++){
                   grid[row][col] = 1 - grid[row][col]; 
               }
           }
        }
        
        for(int col = 1; col < cols; col++){
            int numberOfZerosInTheCurrentColumn = 0;
            int numberOfOnesInTheCurrentColumn = 0;
            
            for(int row = 0; row < rows; row++){
                if(grid[row][col] == 0)
                    numberOfZerosInTheCurrentColumn++;
                else
                   numberOfOnesInTheCurrentColumn++; 
            }
            
            if(numberOfZerosInTheCurrentColumn > numberOfOnesInTheCurrentColumn){
                for(int row = 0; row < rows; row++){
                    grid[row][col] = 1 - grid[row][col]; 
                }
            }
        }
        
        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                int decimalValueOfTheCurrentCell = grid[row][col] << (cols - col - 1);
                score = score + decimalValueOfTheCurrentCell;
            }
        }
        
        return score;
        
    }
}