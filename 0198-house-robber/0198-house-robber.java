//top-bottom approach
// class Solution {
//     Map<Integer, Integer> hm = new HashMap<>();
//     public int rob(int[] nums) {
        
//         if(nums.length == 1)
//             return nums[0];
        
//         hm.put(0, nums[0]);
//         hm.put(1, Math.max(nums[0], nums[1]));
//         return dp(nums.length-1, nums);
        
//     }
    
//     public int dp(int i, int[] nums){
//         if(i == 0 || i == 1)
//             return hm.get(i);
//         if(hm.containsKey(i))
//             return hm.get(i);
//         hm.put(i, Math.max(dp(i-2, nums) + nums[i], dp(i-1, nums)));
        
//         return hm.get(i);
//     }   
// }

//bottom-up approach
class Solution {
    public int rob(int[] nums) {
        
        if(nums.length == 1)
             return nums[0];
        int[] dp = new int[nums.length];
        
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        
        for(int i=2; i<nums.length; i++){
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }
        
        return dp[dp.length-1];
    }
    
}