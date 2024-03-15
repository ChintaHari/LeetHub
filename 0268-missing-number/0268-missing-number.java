class Solution {
    public int missingNumber(int[] nums) {
        int arrSum = 0;

        for(int i = 0; i < nums.length; i++) {
            arrSum += nums[i];
        }

        int n = nums.length;
        int rangeSum = n * (n + 1) / 2;

        return rangeSum - arrSum;
    }
}