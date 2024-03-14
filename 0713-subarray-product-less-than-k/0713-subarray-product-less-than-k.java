class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <=1)
            return 0;
        int count = 0;
        int left = 0, right = 0, currProd = 1;
        for(right = 0; left < nums.length && right<nums.length; right++){
            currProd = currProd * nums[right];
            
            while(left < nums.length && currProd >= k){
                currProd = (int) (currProd/nums[left]);
                left++;
            }
            
            count = count + (right - left + 1);
        }
        return count;
        
    }
}