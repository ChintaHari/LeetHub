/*class Solution {
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
*/

//bottom-up approach.

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] ==  amount + 1 ? -1 : dp[amount];
    }
}

