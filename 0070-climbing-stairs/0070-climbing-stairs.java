// top-bottom appraoch
// class Solution {
//     Map<Integer, Integer> hm = new HashMap<>();
//     public int climbStairs(int n) {
//         return dp(0, n);    
//     }
    
//     public int dp(int index, int n){
//         if(index > n)
//             return 0;
//         if(index == n)
//             return 1;
//         if(hm.containsKey(index))
//             return hm.get(index);
//         hm.put(index, dp(index + 1, n) + dp(index + 2, n));
//         return hm.get(index);
//     }
// }

//bottom-up appraoch
class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        
        if(n==1)
            return 1;

        dp[1] = 1;
        dp[2] = 2;
        
        for(int i=3; i <=n; i++)
            dp[i] = dp[i-1] + dp[i-2];
        
        return dp[n];
        
    }
}