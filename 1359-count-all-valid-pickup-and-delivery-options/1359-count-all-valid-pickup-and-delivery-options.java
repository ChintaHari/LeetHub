//watch : https://www.youtube.com/watch?v=p1tvA-eQFqk
class Solution {
    public int countOrders(int n) {
        long[] dp = new long[501];
        int mod = (int)Math.pow(10, 9) + 7;
        dp[1] = 1L;
        dp[2] = 6L;
        for(int i=2; i<dp.length; i++){
            int oddNumber = (2 * i) - 1;
            int numberOfWays = (oddNumber * (oddNumber + 1)/2);
            dp[i] = (numberOfWays * dp[i-1]) % mod;
        }
        return (int)dp[n];
    }
}