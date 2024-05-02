class Solution {
    public int findMaxK(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        for(int ele : nums)
            set.add(ele);
        
        for(int ele : nums){
            if(ele > 0 && set.contains(-ele))
                max = Math.max(max, ele);
        }
        
        return max == Integer.MIN_VALUE ? -1 : max;
        
    }
}