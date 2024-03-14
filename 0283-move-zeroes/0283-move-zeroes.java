class Solution {
    public void moveZeroes(int[] nums) {
        int zeroPointer = 0;
        
        for (int nonZeroPointer = 0; nonZeroPointer < nums.length; nonZeroPointer++) {
            if (nums[nonZeroPointer] != 0) {
                if (zeroPointer != nonZeroPointer) {
                    nums[zeroPointer] = nums[nonZeroPointer];
                    nums[nonZeroPointer] = 0;
                }
                zeroPointer++;
            }
        }
    }
}
