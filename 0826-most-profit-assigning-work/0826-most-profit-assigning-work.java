class Job{
    int difficulty, profit;
    Job(int difficulty, int profit){
        this. difficulty = difficulty;
        this.profit = profit;
    }
}
class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = profit.length;
        Job jobs[] = new Job[n];
        
        for(int i=0; i<n; i++)
            jobs[i] = new Job(difficulty[i], profit[i]);
        
        Arrays.sort(jobs, (a,b) -> a.difficulty - b.difficulty);
        Arrays.sort(worker);
        
        int maxProfit = 0;
        int bestProfitableWorkToCurrentWorker = 0;
        int i= 0;
        for(int currentWorker : worker){
            while(i < n && currentWorker >= jobs[i].difficulty){
                bestProfitableWorkToCurrentWorker = Math.max(bestProfitableWorkToCurrentWorker, jobs[i].profit);
                i++;
            }
            maxProfit += bestProfitableWorkToCurrentWorker;
        }
        return maxProfit;
    }
}