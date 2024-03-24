class Solution {
    public int maximumGap(int[] nums) {
        if(nums.length < 2)
            return 0;
        Arrays.sort(nums);
        int maxDifference = Integer.MIN_VALUE;
        int left=0, right=0;
        for(right = 1; right < nums.length; right++){
            maxDifference = Math.max(maxDifference, Math.abs(nums[right] - nums[left]));
            left++;
        }
        return maxDifference == Integer.MIN_VALUE ? 0 : maxDifference;
    }
}