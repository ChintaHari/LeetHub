class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, ((a,b) -> a[0] - b[0]));
        List<int[]> result = new ArrayList<>();
        int n = intervals.length;
        
        int[] currentInterval = intervals[0];
        result.add(currentInterval);
        
        for(int i=1; i<n; i++){
            if(currentInterval[1] < intervals[i][0]){
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