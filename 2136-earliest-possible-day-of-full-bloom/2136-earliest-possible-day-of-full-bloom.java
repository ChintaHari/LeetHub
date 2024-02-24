class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int[][] plantTimesToGrowTimes = new int[plantTime.length][2];
        for(int i=0; i<plantTime.length; i++){
            plantTimesToGrowTimes[i][0] = plantTime[i];
            plantTimesToGrowTimes[i][1] = growTime[i];
        }
        
        Arrays.sort(plantTimesToGrowTimes, ((a,b) -> a[1] == b[1] ? a[0] - b[0] : b[1] - a[1] ));
        
        int daysRequiredToPlant = 0, maxBloomingDay = 0;
        for(int[] plantTimesToGrowTime : plantTimesToGrowTimes){
            daysRequiredToPlant = daysRequiredToPlant + plantTimesToGrowTime[0];
            int daysRequiredToBloom = daysRequiredToPlant + plantTimesToGrowTime[1];
            maxBloomingDay = Math.max(maxBloomingDay, daysRequiredToBloom);
        }
        return maxBloomingDay;
        
    }
}