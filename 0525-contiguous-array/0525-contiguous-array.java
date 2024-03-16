class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxLength = 0, runningSum = 0;
        for (int i = 0; i < nums.length; i++) {
            runningSum += (nums[i] == 0) ? -1 : 1;
            if (map.containsKey(runningSum)) 
                maxLength = Math.max(maxLength, i - map.get(runningSum));
            else
                map.put(runningSum, i);
        }
        
        return maxLength;
    }
}
