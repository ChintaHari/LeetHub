class Job{
    int start, end, profit;
    Job(int start, int end, int profit){
        this.start = start;
        this.end = end;
        this.profit = profit;
    }
}
class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        Job[] jobs = new Job[startTime.length];
        
        for(int i=0; i<startTime.length; i++)
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        
        Arrays.sort(jobs, (a, b) -> a.end - b.end);
        
        int dp[] = new int[startTime.length];
        dp[0] = jobs[0].profit;
        
        for(int i=1; i<dp.length; i++){
            int proftIncludingCurrent = jobs[i].profit;
            for(int j=i-1; j>=0; j--){
                if(jobs[i].start >= jobs[j].end){
                    proftIncludingCurrent = proftIncludingCurrent + dp[j];
                    break;
                }
            }
            dp[i] = Math.max(dp[i-1], proftIncludingCurrent);
        }
        
        return dp[dp.length-1];
    }
}