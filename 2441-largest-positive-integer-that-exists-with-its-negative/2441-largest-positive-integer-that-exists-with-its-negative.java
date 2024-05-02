class Solution {
    public int findMaxK(int[] nums) {
        int left = 0, right = nums.length - 1;
        Arrays.sort(nums);
        while(left < right){
            if(-nums[left] == nums[right])
                return nums[right];
            else if(-nums[left] > nums[right])
                left++;
            else 
                right--;
        }
        return -1;
    }
}