class Solution {
    List<List<Integer>> piles;
    int[][] memo;
    int n;
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        n = piles.size();
        memo = new int[n][k+1];

        this.piles = piles;
        for(int i=0; i<n; i++)
            Arrays.fill(memo[i], -1);

        return dp(0, k);
    }

    public int dp(int pile, int remainingCoins){
        if(pile == n || remainingCoins == 0)
            return 0;
        
        if(memo[pile][remainingCoins] != -1)
            return memo[pile][remainingCoins];

        int ans = dp(pile + 1, remainingCoins);
        int currSum = 0;
        for(int j=0; j<Math.min(remainingCoins, piles.get(pile).size()); j++){
            currSum = currSum + piles.get(pile).get(j);
            ans = Math.max(ans, currSum + dp(pile + 1, remainingCoins - j - 1));
        }
        memo[pile][remainingCoins] = ans;
        return ans;
    }
}