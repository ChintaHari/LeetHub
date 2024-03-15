class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int currSum = 0;
        int left=0, right=0;
        for(right =0; right <nums.length && left < nums.length; right++){
            currSum = currSum + nums[right];
            while(left < nums.length && currSum >= target){
                ans = Math.min(ans, right - left + 1);
                currSum = currSum - nums[left];
                left ++;
                
            }
        }
        
        return ans == Integer.MAX_VALUE ? 0 : ans;
        
    }
}