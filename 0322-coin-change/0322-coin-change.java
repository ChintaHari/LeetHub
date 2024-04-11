class Solution {
    int[] memo;
    public int coinChange(int[] coins, int amount) {
        memo = new int[amount + 1];
        Arrays.fill(memo, -2);
        
        return dfs(coins, amount);
    }
    
    public int dfs(int[] coins, int remain){
        if(remain < 0)
            return -1;
        
        if(remain == 0)
            return 0;
        
        if(memo[remain] != -2)
            return memo[remain];
        
        int minCoinCount = Integer.MAX_VALUE;
        for(int coin : coins){
            int count = dfs(coins, remain - coin);
            if(count == -1)
                continue;
            minCoinCount = Math.min(minCoinCount, count + 1);
        }
        
        memo[remain] = minCoinCount == Integer.MAX_VALUE ? -1 : minCoinCount;
        return memo[remain];
    }
}