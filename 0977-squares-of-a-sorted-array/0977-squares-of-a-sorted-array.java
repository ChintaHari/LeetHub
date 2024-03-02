class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        // for(int i=0; i<nums.length; i++)
        //     result[i] = nums[i] * nums[i];
        // Arrays.sort(result);
        // return result;
        int left = 0, right = nums.length-1;
        int resultIndex = nums.length - 1;
        while(left <= right){
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];
            if(leftSquare >= rightSquare){
                result[resultIndex--] = leftSquare;
                left++;
            }
            else{
                result[resultIndex--] = rightSquare;
                right--;
            }    
        }
        return result;
        
    }
}