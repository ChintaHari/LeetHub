class Solution {
    public int longestOnes(int[] nums, int k) {
        int noOfZeroes = 0, left = 0, right = 0, ans = 0;
        for(right = 0; right < nums.length; right++){
            if(nums[right] == 0)
                noOfZeroes ++;
            while(noOfZeroes > k){
                if(nums[left] == 0)
                    noOfZeroes--;
                left++;
            }
           ans = Math.max(ans, right-left+1); 
        }
        return ans;
        
    }
}