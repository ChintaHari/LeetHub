class Solution {
    int n;
    int[][][] memo;
    int[] prices;
    public int maxProfit(int k, int[] prices) {
        n = prices.length;
        memo = new int[n][2][k+1];
        for(int i=0; i<n; i++)
            for(int j=0; j<2; j++)
                Arrays.fill(memo[i][j], -1);
        
        this.prices = prices;
        return dp(0, 0, k);
    }
    
    public int dp(int day, int holdingStock, int remainingTransactions){
        if(day == n || remainingTransactions == 0)
            return 0;
        
        if(memo[day][holdingStock][remainingTransactions] != -1)
            return memo[day][holdingStock][remainingTransactions];
        
        int ans = 0;
        if(holdingStock == 1)
            ans = Math.max(dp(day+1, holdingStock, remainingTransactions), prices[day] + dp(day + 1, 0, remainingTransactions - 1));
        else
            ans = Math.max(dp(day+1, holdingStock, remainingTransactions), -prices[day] + dp(day + 1, 1, remainingTransactions));
        
        memo[day][holdingStock][remainingTransactions] = ans;
        return ans;
        
    }
}