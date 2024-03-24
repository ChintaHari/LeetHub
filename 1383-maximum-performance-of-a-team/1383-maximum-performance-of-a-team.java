//Key point: We need to increase the multiplication rate that gives us maximum team performance.
//To increase the rate, we need to focus on what we are multiplying. here it is efficiency.
//So Construct 2D array and sort it based on decreasing efficiency. Such that we can start with highest efficiency first and keep on updating the max team performance later.
//Watch : https://www.youtube.com/watch?v=FW73Sxo0YMA&t=807s

class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        List<int[]> list = new ArrayList<>();
        for(int i=0; i<n; i++)
            list.add(new int[]{speed[i], efficiency[i]});
        
        Collections.sort(list, (a,b) -> b[1] - a[1]);
        
        long currentSpeed = 0;
        int minEfficiency = list.get(0)[1];
        long maxPerformance = Long.MIN_VALUE;
        int mod = (int)(Math.pow(10,9) + 7);
        
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int[] sublist : list){
            queue.add(sublist[0]);
            if(queue.size() > k)
                currentSpeed = currentSpeed - queue.remove();
            currentSpeed = currentSpeed + sublist[0];
            minEfficiency = Math.min(minEfficiency, sublist[1]);
            maxPerformance = Math.max(maxPerformance, currentSpeed * minEfficiency);  
        }
        return (int) (maxPerformance % mod);
    }
}