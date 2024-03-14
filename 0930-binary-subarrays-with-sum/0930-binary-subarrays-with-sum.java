class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        int count = 0;
        for(int i=1; i<prefixSum.length; i++)
            prefixSum[i] = prefixSum[i-1] + nums[i];
        
        for(int left =0; left < prefixSum.length; left++){
            for(int right = left; right < prefixSum.length; right++){
                if(prefixSum[right] - prefixSum[left] + nums[left] == goal)
                    count++;
            }
        }
        
        return count;
        
    }
}