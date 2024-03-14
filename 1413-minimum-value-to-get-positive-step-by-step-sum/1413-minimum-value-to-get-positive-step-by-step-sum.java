class Solution {
    public int minStartValue(int[] nums) {
        int ans = 0;
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for(int i=1; i<nums.length; i++)
            prefixSum[i] = prefixSum[i-1] + nums[i];
        ans = Arrays.stream(prefixSum).min().getAsInt();
        return ans < 0 ? Math.abs(ans) + 1 : 1;
        
    }
}