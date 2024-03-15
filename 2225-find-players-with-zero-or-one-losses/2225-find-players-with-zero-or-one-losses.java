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


// import java.util.Arrays;
// import java.util.List;
// import java.util.stream.Collectors;
// class Solution {
//     public List<List<Integer>> findWinners(int[][] matches) {
//         HashMap<Integer, Integer> lost = new HashMap<>();
//         Set<Integer> set = new HashSet<>(Arrays.stream(matches).flatMapToInt(Arrays::stream).distinct().boxed().collect(Collectors.toList()));
//         Set<Integer> wonAllList = new TreeSet<>();
//         Set<Integer> lostExactlyOne = new TreeSet<>();
//         List<List<Integer>> finalList = new ArrayList<>();
        
//         for(int i=0; i<matches.length; i++)
//             lost.put(matches[i][1], lost.getOrDefault(matches[i][1], 0)+1);
        
//         for(int ele: set){
//             if(!lost.containsKey(ele))
//                 wonAllList.add(ele);
//             else if(lost.get(ele) == 1)
//                 lostExactlyOne.add(ele);
//         }
        
//         finalList.add(new ArrayList<>(wonAllList));
//         finalList.add(new ArrayList<>(lostExactlyOne));
        
//         return finalList;
        
//     }
// }