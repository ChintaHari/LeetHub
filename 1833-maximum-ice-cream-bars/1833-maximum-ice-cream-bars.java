class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int i=0, n=costs.length, ans=0;
        while(i<n && coins >= costs[i]){
            ans ++;
            coins = coins - costs[i];
            i++;
        }
        return ans;
        
    }
}