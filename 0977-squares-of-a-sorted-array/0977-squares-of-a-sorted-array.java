class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] sortedSqrs = new int[nums.length];
        int left =0, right = nums.length - 1, index;
        
        for(index = nums.length-1; index >=0 && left<=right; index--){
            int rightSquare = nums[right] * nums[right];
            int leftSquare = nums[left] * nums[left];
            if(rightSquare >= leftSquare){
                sortedSqrs[index] = rightSquare;
                right--;
            }
            else{
                sortedSqrs[index] = leftSquare;
                left++;
            }
        }
        
        return sortedSqrs;
        
    }
}