class Solution {
    HashMap<Integer, Integer> hm = new HashMap<>();
    String firstString = "", secondString = "";
    int m=0, n=0;
    int[][] memo;
    public int longestCommonSubsequence(String text1, String text2) {
        firstString = text1;
        secondString = text2;
        m = firstString.length();
        n = secondString.length();
        
       memo = new int[m][n];
        
        for(int i=0; i<m; i++)
            Arrays.fill(memo[i], -1);
       
        return dp(0, 0);
    }
    
    public int dp(int first, int second){
        if(first == firstString.length() || second == secondString.length())
            return 0;
        
        if(memo[first][second] != -1)
            return memo[first][second];
        
        int ans = 0;
        if(firstString.charAt(first) == secondString.charAt(second))
            ans = 1 + dp(first + 1, second + 1);
        
        else
            ans = Math.max(dp(first+1, second), dp(first, second + 1));
        
        memo[first][second] = ans;
        return ans;
        
    }
}