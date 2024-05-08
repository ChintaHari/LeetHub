class Pair{
    int index, atheleteScore;    
    public Pair(int index, int atheleteScore){
        this.index = index;
        this.atheleteScore = atheleteScore;
    }
}
class Solution {
    public String[] findRelativeRanks(int[] score) {
        String[] titles = new String[]{"Gold Medal","Silver Medal","Bronze Medal"} ;
        int number = 4;
        
        PriorityQueue<Pair> pq = new  PriorityQueue<>((a,b) -> b.atheleteScore - a.atheleteScore);
        
        for(int i = 0; i <score.length; i++)
            pq.offer(new Pair(i, score[i]));
        
        String[] result = new String[score.length];
        
        for(int i=0; i<result.length; i++){
            Pair pair = pq.poll();
            
            int index = pair.index;
            int atheleteScore = pair.atheleteScore;
            
            if(i < 3)
                result[index] = titles[i];
            else
                result[index] = String.valueOf(number++);
        }
        
        return result;
    }
}