class Solution {
    public int countOrders(int n) {
        int mod = (int)Math.pow(10, 9) + 7;
        long[] dp = new long[501];
        dp[1] = (long)1;
        dp[2] = (long)6;
        for(int i=3; i<=n; i++){
            int oddNumber = (2*i) - 1;
            int totalNumberOfWays = (int)(oddNumber * (oddNumber + 1))/2;
            dp[i] = (totalNumberOfWays * dp[i-1]) % mod;
        }
        return (int)dp[n];
        
    }
}