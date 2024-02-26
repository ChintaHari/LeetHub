class Solution {
    int limit;
    public int smallestDivisor(int[] nums, int threshold) {
        limit = threshold;
        int left = 1;
        int right = Arrays.stream(nums).max().getAsInt();
        
        while(left <= right){
            int mid = left + (right - left)/2;
            if(check(mid, nums))
                right = mid - 1;
            else
                left = mid + 1;
        }
        
        return left;
    }
    
    public boolean check(int divisor, int[] nums){
        double sum = 0;
        for(double num: nums)
            sum = sum + (double)Math.ceil(num/divisor);
        return sum <= limit;
    }
}