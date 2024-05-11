class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        double totalMinimumCost = Double.MAX_VALUE;
        double currentTotalQuality = 0;
        List<Pair<Double, Integer>> wageToQualityRatio = new ArrayList<>();
        PriorityQueue<Integer> highQualityWorkers = new PriorityQueue<>((a,b) -> b - a);
        
        for(int i=0; i<n; i++)
            wageToQualityRatio.add(new Pair((double) wage[i]/quality[i], quality[i]));
        
        Collections.sort(wageToQualityRatio, Comparator.comparingDouble(Pair :: getKey));
        
        for(int i=0; i<n; i++){
            highQualityWorkers.offer(wageToQualityRatio.get(i).getValue());
            currentTotalQuality = currentTotalQuality + wageToQualityRatio.get(i).getValue();
            
            if(highQualityWorkers.size() > k)
                currentTotalQuality = currentTotalQuality - highQualityWorkers.poll();
            
            if(highQualityWorkers.size() == k)
                totalMinimumCost = Math.min(totalMinimumCost,
                                            currentTotalQuality * wageToQualityRatio.get(i).getKey());
        }
        
        return totalMinimumCost;
    }
}