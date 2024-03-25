class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        
        int[] currentInterval = intervals[0];
        result.add(currentInterval);
        
        for(int i=1; i<intervals.length; i++){
            if(intervals[i][0] >  currentInterval[1]){
                currentInterval = intervals[i];
                result.add(currentInterval);
            }
            else{
                currentInterval[0] = Math.min(currentInterval[0], intervals[i][0]);
                currentInterval[1] = Math.max(currentInterval[1], intervals[i][1]);
            }
        }
        
        return result.toArray(new int[result.size()][]);
    }
}