class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        List<int[]> list = new ArrayList<>();
        for(int i=0; i<n; i++)
            list.add(new int[]{efficiency[i], speed[i]});
        Collections.sort(list, (a,b) -> b[0]-a[0]);
        
        long maxPerformance = 0, currSpeed = 0;
        int minEfficiency = Integer.MAX_VALUE;
        int mod = (int)(Math.pow(10,9) + 7);
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int[] subList : list){
            
            queue.add(subList[1]);
            if(queue.size() > k)
                currSpeed = currSpeed - queue.remove();
            currSpeed = currSpeed + subList[1];
            minEfficiency = Math.min(minEfficiency, subList[0]);
            maxPerformance = Math.max(maxPerformance, (currSpeed * minEfficiency));
        }
        return (int) (maxPerformance % mod);
    }
}