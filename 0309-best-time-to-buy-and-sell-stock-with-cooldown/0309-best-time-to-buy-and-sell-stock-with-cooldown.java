class Solution {
    int[][] memo;
    int[] prices;
    int n;
    public int maxProfit(int[] prices) {
        n = prices.length;
        
        memo = new int[n][2];
        for(int i=0; i<n; i++)
            Arrays.fill(memo[i], -1);
        
        this.prices = prices;
        return dp(0, 0);
    }
    
    public int dp(int day, int holding){
        if(day >= prices.length)
            return 0;
        
        if(memo[day][holding] != -1)
            return memo[day][holding];
        
        int ans = 0;
        if(holding == 1)
            ans = Math.max(dp(day + 1, holding), prices[day] + dp(day + 2, 0));
        else
            ans = Math.max(dp(day + 1, holding), -prices[day] + dp(day + 1, 1));
        
        memo[day][holding] = ans;
        return ans; 
    }
}