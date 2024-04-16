class Solution {
    public int maxSubArray(int[] nums) {
        int maxSubArraySum = nums[0];
        int currSum = 0;
        for(int ele: nums){
            if(currSum < 0)
                currSum = 0;
            currSum = currSum + ele;
            maxSubArraySum = Math.max(maxSubArraySum, currSum);
        }
        return maxSubArraySum;
    }
}