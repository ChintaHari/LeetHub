//top-bottom appraoch
// class Solution {
//     HashMap<Integer, Integer> hm = new HashMap<>();
//     String firstString = "", secondString = "";
//     int m=0, n=0;
//     int[][] memo;
//     public int longestCommonSubsequence(String text1, String text2) {
//         firstString = text1;
//         secondString = text2;
//         m = firstString.length();
//         n = secondString.length();
        
//        memo = new int[m][n];
        
//         for(int i=0; i<m; i++)
//             Arrays.fill(memo[i], -1);
       
//         return dp(0, 0);
//     }
    
//     public int dp(int first, int second){
//         if(first == firstString.length() || second == secondString.length())
//             return 0;
        
//         if(memo[first][second] != -1)
//             return memo[first][second];
        
//         int ans = 0;
//         if(firstString.charAt(first) == secondString.charAt(second))
//             ans = 1 + dp(first + 1, second + 1);
        
//         else
//             ans = Math.max(dp(first+1, second), dp(first, second + 1));
        
//         memo[first][second] = ans;
//         return ans;
        
//     }
// }

//bottom-up approach
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        
        int dp[][] = new int[n + 1][m + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        
        return dp[0][0];
    }
}