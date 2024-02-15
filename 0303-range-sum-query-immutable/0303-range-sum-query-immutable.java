class NumArray {
    int[] prefixSum;
    List<Integer> numsList = new ArrayList<>();
    public NumArray(int[] nums) {
        numsList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        int n = nums.length;
        prefixSum = new int[n];
        prefixSum[0] = nums[0];
        for(int i=1; i<n; i++)
            prefixSum[i] = nums[i] + prefixSum[i-1];
    }
    
    public int sumRange(int left, int right) {
        return prefixSum[right] - prefixSum[left] + numsList.get(left);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */