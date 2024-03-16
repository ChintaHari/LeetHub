class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int currSum = 0, ans = 0, left = 0, right = 0;
        hm.put(0,1);
        for(right = 0; right < nums.length; right++){
            currSum = currSum + nums[right];
            if(hm.containsKey(currSum - goal))
                ans = ans + hm.get(currSum - goal);
            hm.put(currSum, hm.getOrDefault(currSum, 0) + 1);
        }
        return ans;
    }
}