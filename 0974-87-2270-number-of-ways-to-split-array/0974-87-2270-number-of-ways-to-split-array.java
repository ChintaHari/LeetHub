class Solution {
    public int waysToSplitArray(int[] nums) {
        int ans = 0, n = nums.length;
        long prefixSum[] = new long[n];
        prefixSum[0] = nums[0];
        for(int i=1; i<n; i++)
            prefixSum[i] = prefixSum[i-1] + nums[i];
        
        for(int i=0; i<nums.length - 1; i++){
            if((prefixSum[i] >= prefixSum[n-1] - prefixSum[i]))
                ans ++;
        }
        return ans;
        
    }
}