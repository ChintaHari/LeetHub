class Solution {
    int[] nums;
    int n = 0;
    public int minSwaps(int[] nums) {
        this.nums = nums;
        n = nums.length;
        
        int numberOfSwapsNeededForZero = swapsCountFinder(0);
        
        if(numberOfSwapsNeededForZero == 0 || numberOfSwapsNeededForZero == n)
            return 0;
        
        int numberOfSwapsNeededForOne = swapsCountFinder(1);
        
        return Math.min(numberOfSwapsNeededForZero, numberOfSwapsNeededForOne);
    }
    
    public int swapsCountFinder(int value){
        int totalCountOfValueInArray = 0;
        
        for(int i=0; i<n; i++)
            if(nums[i] == value)
                totalCountOfValueInArray++;
        
        if(totalCountOfValueInArray == 0 || totalCountOfValueInArray == n)
            return 0;
        
        int left = 0, right = 0;
        int maxCountOfValueInWindow = 0, currentCountOfValueInWindow = 0;
        
        for(right = 0; right < n; right++){
            if(nums[right] == value)
                currentCountOfValueInWindow++;
            
            if(right - left + 1 > totalCountOfValueInArray){
                if(nums[left] == value)
                    currentCountOfValueInWindow--;
                left++;
            }
            
            maxCountOfValueInWindow = Math.max(maxCountOfValueInWindow, currentCountOfValueInWindow);
        }
        
        return totalCountOfValueInArray - maxCountOfValueInWindow;
    }
}