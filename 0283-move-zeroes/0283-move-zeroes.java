class Solution {
    public void moveZeroes(int[] nums) {
        int left=0, right =0;
        for(right = 0; right < nums.length; right++){
                if(nums[right] != 0){
                    if(right != left){
                        nums[left] = nums[right];
                        nums[right] = 0;
                       
                    }
                     left++;
                }
        }
    }
}