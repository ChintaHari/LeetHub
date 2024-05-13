/* 4 Simple steps to solve this problem:
1. First, we need to flip all the rows such that the first element of each row is 1. Because flipping the first element of a row is always beneficial as it will lead to a larger score.
2. Next, we need to flip only those columns (starting from index 1) where the number of 0s is greater than the number of 1s. Because flipping a column with more 0s will lead to a larger score.
3. Finally, we need to calculate the score by converting the binary representation of each row into a decimal number.
4. So how did I do the step 3?
    - I iterated over each row and each column of the grid.
    - I calculated the decimal value of the current cell by multiplying the value of the current cell with 2 raised to the power of (cols - col - 1).
    - The above step is called LEFT SHIFT
    - I added the decimal value of the current cell to the score.
    - Finally, I returned the score.
*/


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
                // int decimalValueOfTheCurrentCell = grid[row][col] << (cols - col - 1);
                // score = score + decimalValueOfTheCurrentCell;
                int decimalValueOfTheCurrentCell = grid[row][col] == 1 ? (int)Math.pow(2, cols - col - 1) : 0;
                score = score + decimalValueOfTheCurrentCell;
            }
        }
        
        return score;
        
    }
}