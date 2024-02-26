import java.util.Arrays;

class Solution {
    public int splitArray(int[] nums, int k) {
        long left = Arrays.stream(nums).max().getAsInt();
        long right = Arrays.stream(nums).sum();
        while(left <= right){
            long mid = left + (right - left)/2;
            
            int subArrays = 1; 
            long currSum = 0;
            for(int num: nums){
                currSum += num;
                if(currSum > mid){ 
                    subArrays++;
                    currSum = num; 
                }
            }
            
            if(subArrays > k) 
                left = mid + 1;
            else 
                right = mid - 1;
        }
        return (int)left;
    }
}
