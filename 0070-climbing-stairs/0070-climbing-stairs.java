class Solution {
    Map<Integer, Integer> hm = new HashMap<>();
    public int climbStairs(int n) {
        
        return dp(0, n);
        
    }
    
    public int dp(int index, int n){
        if(index > n)
            return 0;
        if(index == n)
            return 1;
        if(hm.containsKey(index))
            return hm.get(index);
        hm.put(index, dp(index + 1, n) + dp(index + 2, n));
        return hm.get(index);
    }
    
    
}