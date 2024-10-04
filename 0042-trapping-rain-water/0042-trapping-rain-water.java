class Solution {
    public int trap(int[] height) {
        
        if(height.length == 0)
            return 0;
        
        int left = 0, right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];
        int totalWater = 0;
        
        while(left < right){
            if(leftMax < rightMax){
                left = left + 1;
                leftMax = Math.max(leftMax, height[left]);
                totalWater = totalWater + (leftMax -  height[left]);
            }
            
            else{
                right = right - 1;
                rightMax = Math.max(rightMax, height[right]);
                totalWater = totalWater + (rightMax -  height[right]);
            }
        }
        return totalWater;
    }
}