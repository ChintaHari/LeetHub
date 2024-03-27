class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int firstPointer = 0, secondPointer = 0;
        List<int[]> result = new ArrayList<>();
        while(firstPointer < firstList.length && secondPointer < secondList.length){
            int currentFirstInterval[] = firstList[firstPointer];
            int currentSecondInterval[] = secondList[secondPointer];
            
            int startMax = Math.max(currentFirstInterval[0], currentSecondInterval[0]);
            int endMin = Math.min(currentFirstInterval[1], currentSecondInterval[1]);
            
            if(startMax <= endMin)
                result.add(new int[]{startMax, endMin});
            
            if(currentFirstInterval[1] < currentSecondInterval[1])
                firstPointer++;
            else
               secondPointer++; 
        }
        return result.toArray(new int[result.size()][]);
    }
}