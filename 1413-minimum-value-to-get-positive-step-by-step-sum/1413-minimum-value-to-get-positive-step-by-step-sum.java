class Solution {
    public int minStartValue(int[] nums) {
        int ans = 0;
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        int minSum = prefixSum[0];
        for(int i=1; i<nums.length; i++){
            prefixSum[i] = prefixSum[i-1] + nums[i];
            minSum = Math.min(minSum, prefixSum[i]);
        }
        //ans = Arrays.stream(prefixSum).min().getAsInt();
        return minSum < 0 ? Math.abs(minSum) + 1 : 1;
        
    }
}