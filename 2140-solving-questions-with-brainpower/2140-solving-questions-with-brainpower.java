class Solution {
    Map<Integer, Long> hm = new HashMap<>();
    public long mostPoints(int[][] questions) {
       return dp(0, questions);
    }
    
    public long dp(int i, int[][] questions){
        if(i >= questions.length)
            return 0;
        
        if(hm.containsKey(i))
            return hm.get(i);
        
        int indexAtWhichNextSumShouldBeSolved = i + questions[i][1] + 1;
        hm.put(i, Math.max(questions[i][0] + dp(indexAtWhichNextSumShouldBeSolved, questions), dp(i+1, questions)));
        return hm.get(i);
    }
}