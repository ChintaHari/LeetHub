class Solution {
    int limit;
    public int minEatingSpeed(int[] piles, int h) {
        limit = h;
        int minEatingSpeed = 1; //Consider it as variable "left" in binary Search 
        int maxEatingSpeed = Arrays.stream(piles).max().getAsInt(); //Consider it as variable "right" in binary Search
        
        while(minEatingSpeed <= maxEatingSpeed){
            int middleEatingSpeed = minEatingSpeed + (maxEatingSpeed - minEatingSpeed)/2;
            if(checkIfAllBananasCanBeEatenWithThisSpeed(middleEatingSpeed, piles))
                maxEatingSpeed = middleEatingSpeed - 1;
            else
                minEatingSpeed = middleEatingSpeed + 1;
        }
        return minEatingSpeed;
    }
    
    public boolean checkIfAllBananasCanBeEatenWithThisSpeed(double speed, int[] piles){
        double hours = 0;
        for(double pile : piles)
            hours = hours + Math.ceil(pile/speed);
        return hours <= limit;
    }
}