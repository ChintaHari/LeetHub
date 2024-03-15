class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0,1);
        
        int ans =0, currSum = 0;
        for(int num: nums){
            currSum = currSum + num;
            if(hm.containsKey(currSum - k)){
                ans = ans + hm.get(currSum - k);
            }
            hm.put(currSum, hm.getOrDefault(currSum, 0) + 1);
        }
        return ans;
    }
}