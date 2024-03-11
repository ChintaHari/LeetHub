//top-bottom appraoch
// class Solution {
//     int[] prices;
//     int[][] memo;
//     int n;
//     int fee;
//     public int maxProfit(int[] prices, int fee) {
//         n = prices.length;
        
//         memo = new int[n][2];
//         for(int i=0; i<n; i++)
//                 Arrays.fill(memo[i], -1);
        
//         this.prices = prices;
//         this.fee = fee;
//         return dp(0,0);
//     }
    
//     public int dp(int day, int holding){
//         if(day == prices.length)
//             return 0;
        
//         if(memo[day][holding] != -1)
//             return memo[day][holding];
        
//         int ans = 0;
//         if(holding == 1)
//             ans = Math.max(dp(day + 1, holding), prices[day] - fee + dp(day + 1, 0));
//         else
//             ans = Math.max(dp(day + 1, holding), -prices[day] + dp(day + 1, 1));
        
//         memo[day][holding] = ans;
//         return ans;
//     }
// }


//bottom-up appraoch
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        if (n == 0) return 0;
        
        int[][] dp = new int[n][2];
        
        dp[0][0] = 0; // Not holding a stock on day 0
        dp[0][1] = -prices[0] - fee; // Holding a stock on day 0, after buying it and paying the fee
        
        for (int day = 1; day < n; day++) {
            dp[day][0] = Math.max(dp[day - 1][0], dp[day - 1][1] + prices[day]);
            dp[day][1] = Math.max(dp[day - 1][1], dp[day - 1][0] - prices[day] - fee);
        }
        
        // The answer is the max profit on the last day when not holding a stock
        return dp[n - 1][0];
    }
}
