class Solution {
    public int pivotIndex(int[] nums) {
        int pivot = -1;
        int n = nums.length;
        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];
        for(int i=1; i<n; i++)
            prefixSum[i] = prefixSum[i-1] + nums[i];
        for(int i=0 ; i<n; i++){
            if(i==0 && 0 == prefixSum[n-1] - prefixSum[i])
                return i;
            else if(i == n-1 && prefixSum[n-2] == 0)
                return i;
            else if ((i>0 && i+1 <n) && prefixSum[i-1] == prefixSum[n-1] - prefixSum[i+1] + nums[i+1])
                return i;
        }
        
        return pivot;
        
    }
}