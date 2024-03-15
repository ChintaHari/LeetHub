class NumArray {
    int[] prefixSum, nums;
    public NumArray(int[] nums) {
        this.nums = nums;
        prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for(int i=1 ; i<nums.length; i++)
            prefixSum[i] = prefixSum[i-1] + nums[i];
    }
    
    public int sumRange(int left, int right) {
        return prefixSum[right] - prefixSum[left] + nums[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */