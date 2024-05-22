class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        
        for(int i=1; i<nums.length; i++)
            prefixSum[i] = prefixSum[i-1] + nums[i];
        
        int leftMostIndex = 0, rightMostIndex = nums.length - 1;
        
        for(int i=0; i<nums.length; i++){
            if(i == leftMostIndex && 0 == prefixSum[n-1] - prefixSum[i])
                return leftMostIndex;
            else if (i == rightMostIndex && prefixSum[n-2] == 0)
                return rightMostIndex;
            else{
                if( i>0 && i<n && prefixSum[i-1] == prefixSum[n-1] - prefixSum[i])
                    return i;
            }
        }
        return -1;
    }
}