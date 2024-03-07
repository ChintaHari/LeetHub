// top-down appraoch
// class Solution {
//     Map<Integer, Integer> hm = new HashMap<>();
//     public int minCostClimbingStairs(int[] cost) {
// }
//         return dp(cost.length, cost);
//     }
    
//     public int dp(int i, int[] cost){
//         if(i==0 || i==1)
//             return 0;
//         if(hm.containsKey(i))
//             return hm.get(i);
        
//         hm.put(i, Math.min(dp(i-1, cost) + cost[i-1], dp(i-2, cost) + cost[i-2]));
        
//         return hm.get(i);
//     }
// }

//bottom-up appraoch
class Solution{
    public int minCostClimbingStairs(int[] cost) {
        int dp[] = new int[cost.length + 1];
        
        dp[0] = 0;
        dp[1] = 0;
        
        for(int i=2; i<=cost.length; i++){
            dp[i] = Math.min(dp[i-1] + cost[i-1], dp[i-2] + cost[i-2]);
        }
        
        return dp[dp.length - 1];
    }
    
}