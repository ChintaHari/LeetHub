//top-bottom appraoch
// class Solution {
//     Map<Integer, Integer> hm = new HashMap<>();
//     public int lengthOfLIS(int[] nums) {
//         int ans = 1;
//         if(nums.length == 1)
//             return ans;
        
//         for(int i=0; i<nums.length; i++)
//             ans = Math.max(ans, dp(i, nums));
        
//         return ans;
//     }
//     public int dp(int i, int[] nums){
//         if(hm.containsKey(i))
//             return hm.get(i);
        
//         int ans=1;
//         for(int j=0; j<i; j++)
//             if(nums[j] < nums[i])
//                 ans = Math.max(ans, dp(j, nums) + 1);
        
//         hm.put(i, ans);
//         return ans;
//     }
// }

//bottom-up appraoch
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        
        int ans = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    ans = Math.max(ans, dp[i]);
                }
            }
        }
        
        return ans;
    }
}