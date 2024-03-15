class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> lostNoMatches = new ArrayList<>();
    List<Integer> lostOneMatch = new ArrayList<>();
    HashMap<Integer, Integer> winners = new HashMap<>();
    HashMap<Integer, Integer> losers = new HashMap<>();
    
    public List<List<Integer>> findWinners(int[][] matches) {
        
        for(int[] match : matches){
            int winner = match[0], loser = match[1];
            winners.put(winner, winners.getOrDefault(winner, 0) + 1);
            losers.put(loser, losers.getOrDefault(loser, 0) + 1);
        }
        
        for(int winnerKey : winners.keySet())
            if(! losers.containsKey(winnerKey))
                lostNoMatches.add(winnerKey);
        
        
        for(int loserKey : losers.keySet())
            if(losers.get(loserKey) == 1)
                lostOneMatch.add(loserKey);
        
        Collections.sort(lostNoMatches);
        Collections.sort(lostOneMatch);
        
        result.add(new ArrayList<>(lostNoMatches));
        result.add(new ArrayList<>(lostOneMatch));
        
        return result;
    }
}