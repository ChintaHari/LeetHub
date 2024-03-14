class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double maxAverge =  -Double.MAX_VALUE, currSum = 0.0;
        int left=0, right=0;
        for(right =0; right<nums.length; right++){
            currSum = currSum + nums[right];
            if(right - left + 1 == k){
                maxAverge = Math.max(maxAverge, (double)(currSum/k));
                currSum = currSum - nums[left];
                left++;
            }
        }
        return maxAverge;
        
    }
}