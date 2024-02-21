class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a,b) -> b[1]-a[1]);
        int total = 0;
        int i=0;
        while(truckSize > 0 && i<boxTypes.length){
            if(boxTypes[i][0] <= truckSize){
                total = total + boxTypes[i][0] * boxTypes[i][1];
                truckSize = truckSize - boxTypes[i][0];
                i++;
            }
            
            else{
                total = total + truckSize * boxTypes[i][1];
                i++;
                truckSize = 0;
            }

        }
        return total;
        
    }
}