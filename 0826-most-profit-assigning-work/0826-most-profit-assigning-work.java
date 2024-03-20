class Job{
    int difficulty, profit;
    Job(int difficulty, int profit){
        this.difficulty = difficulty;
        this.profit = profit;
    }
}

class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        Job[] jobs = new Job[n];
        for(int i=0; i<n; i++)
            jobs[i] = new Job(difficulty[i], profit[i]);
        
        Arrays.sort(jobs, (a,b) -> a.difficulty - b.difficulty);
        Arrays.sort(worker);
        
        int bestProfitableWorkForWorker = 0;
        int maxProfit = 0;
        int i=0;
        for(int capabiltyOfCurrentWorker : worker){
            while(i < n && capabiltyOfCurrentWorker >= jobs[i].difficulty){
                bestProfitableWorkForWorker = Math.max(bestProfitableWorkForWorker, jobs[i].profit);
                i++;
            }
            maxProfit = maxProfit + bestProfitableWorkForWorker; 
        }
        return maxProfit;
    }
}