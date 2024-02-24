class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int[] flattenedArray = Arrays.stream(matrix).flatMapToInt(Arrays::stream).toArray();
        int left =0, right = flattenedArray.length - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(flattenedArray[mid] == target)
                return true;
            if(flattenedArray[mid] > target)
                right = mid-1;
            if(flattenedArray[mid] < target)
                left = mid + 1;
        }
        return false;
        
    }
}