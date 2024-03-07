//top-bottom appraoch
class Solution {
    Map<Integer, Integer> hm = new HashMap<>();
    public int lengthOfLIS(int[] nums) {
        int ans = 1;
        if(nums.length == 1)
            return ans;
        
        for(int i=0; i<nums.length; i++)
            ans = Math.max(ans, dp(i, nums));
        
        return ans;
    }
    public int dp(int i, int[] nums){
        if(hm.containsKey(i))
            return hm.get(i);
        
        int ans=1;
        for(int j=0; j<i; j++)
            if(nums[j] < nums[i])
                ans = Math.max(ans, dp(j, nums) + 1);
        
        hm.put(i, ans);
        return ans;
    }
}