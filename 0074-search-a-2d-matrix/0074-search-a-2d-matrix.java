class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length, left =0, right = (rows * cols) -1;
        while(left <= right){
            int mid = left + (right - left)/2;
            int row = mid / cols;
            int col = mid % cols;
            int currElement = matrix[row][col]; 
            if(currElement == target)
                return true;
            if(currElement < target)
                left = mid + 1;
            if(currElement > target)
                right = mid -1;
        }
        return false;
    }
}