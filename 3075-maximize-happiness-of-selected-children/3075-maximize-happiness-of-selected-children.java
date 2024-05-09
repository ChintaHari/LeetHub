class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);

        for (int ele : happiness) 
            pq.add(ele);
        
        long sum = 0;
        int turns = 0;

        for (int i = 0; i < k; i++) {
            sum = sum + Math.max(pq.poll() - turns, 0);
            turns++;
        }

        return sum;
    }
}