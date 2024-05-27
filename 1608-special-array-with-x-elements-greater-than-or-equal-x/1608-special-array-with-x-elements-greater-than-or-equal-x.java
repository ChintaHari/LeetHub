class Solution {
 
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        for(int i=1; i<=nums.length; i++){
            int equalOrFirstGreaterNumber = getEqualOrFirstGreaterNumber(nums, i);
            int count = nums.length - equalOrFirstGreaterNumber;
            if(count == i)
                return i;
        }
        return -1;
    }
    
    public int getEqualOrFirstGreaterNumber(int[] nums, int number){
        int left = 0, right = nums.length-1;
        int found = nums.length;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] >= number){
                found = mid;
                right = mid - 1;
            }
            else
                left = mid + 1;
        }
        return found;
    }
}