class Solution {
    int[] memo, coins;
    public int coinChange(int[] coins, int amount) {
        this.coins = coins;
        memo = new int[amount + 1];
        Arrays.fill(memo, -2);
        memo[0] = 0;
        
        dfs(amount);
        return memo[amount];
    }
    
    public int dfs(int remain){
        if(remain < 0)
            return -1;
        
        if(memo[remain] != -2)
            return memo[remain];
        
        int minCount = Integer.MAX_VALUE;
        for(int coin : coins){
            int count = dfs(remain - coin);
            if(count == -1)
                continue;
            minCount = Math.min(minCount, count + 1);
        }
        
        memo[remain] = minCount == Integer.MAX_VALUE ? -1 : minCount;
        return memo[remain];
    }
}