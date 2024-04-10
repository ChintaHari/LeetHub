class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int num : nums)
            hm.put(num, hm.getOrDefault(num,0) + 1);
        
        int maxDegree = hm.values().stream().max(Integer::compareTo).orElse(0);
        System.out.println(maxDegree);
        List<Integer> numsList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        
        int minSubArrayLength = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
            if(hm.get(nums[i]) == maxDegree){
                minSubArrayLength = Math.min(minSubArrayLength, 
                                              numsList.lastIndexOf(nums[i]) - numsList.indexOf(nums[i]) + 1);
            }
        }
        
        return minSubArrayLength == Integer.MAX_VALUE ? 0 : minSubArrayLength;
        
    }
}