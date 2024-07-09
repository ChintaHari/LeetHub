class Solution {
    public double averageWaitingTime(int[][] customers) {
        long finishedTime = 0;   
        long sumOfWaitingTimes = 0;  
        for (int[] customer : customers) {
            int arrivalTime = customer[0];
            int timeRequired = customer[1];
            
            if (finishedTime < arrivalTime) {
                finishedTime = arrivalTime;
            }
            
            finishedTime += timeRequired;  
            sumOfWaitingTimes += (finishedTime - arrivalTime);  
        }
        
        return (double) sumOfWaitingTimes / customers.length;  
    }
}
