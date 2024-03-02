class Solution {
    int size;
    Set<Integer> diagonals = new HashSet<>();
    Set<Integer> antiDiagonals = new HashSet<>();
    Set<Integer> cols = new HashSet<>();
    int row = 0;
    public int totalNQueens(int n) {
        size = n;
        return backtrack(row, size);
    }
    
    public int backtrack(int row, int size){
        if(row == size)
            return 1;
        
        int solutions = 0;
        for(int col = 0; col < size; col ++){
            int currentDiagonalValue = row - col;
            int currentAntiDiagonalValue = row + col;
            if(cols.contains(col) || diagonals.contains(currentDiagonalValue) ||  antiDiagonals.contains(currentAntiDiagonalValue))
                continue;
            
            cols.add(col);
            diagonals.add(currentDiagonalValue);
            antiDiagonals.add(currentAntiDiagonalValue);
            
            solutions = solutions + backtrack(row + 1, size);
            
            cols.remove(col);
            diagonals.remove(currentDiagonalValue);
            antiDiagonals.remove(currentAntiDiagonalValue);
        }
        return solutions;
    }
}