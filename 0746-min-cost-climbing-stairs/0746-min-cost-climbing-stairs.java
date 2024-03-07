class Solution {
    Map<Integer, Integer> hm = new HashMap<>();
    public int minCostClimbingStairs(int[] cost) {
        return dp(cost.length, cost);
    }
    
    public int dp(int i, int[] cost){
        if(i==0 || i==1)
            return 0;
        if(hm.containsKey(i))
            return hm.get(i);
        
        hm.put(i, Math.min(dp(i-1, cost) + cost[i-1], dp(i-2, cost) + cost[i-2]));
        
        return hm.get(i);
    }
}