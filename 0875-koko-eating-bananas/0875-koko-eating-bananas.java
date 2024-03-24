class Solution {
    int[] piles;
    int limit;
    public int minEatingSpeed(int[] piles, int h) {
        this.piles = piles;
        limit = h;
        
        int minEatingSpeed = 1;
        int maxEatingSpeed = Arrays.stream(piles).max().getAsInt();
        
        while(minEatingSpeed <= maxEatingSpeed){
            int middleEatingSpeed = minEatingSpeed + (maxEatingSpeed - minEatingSpeed)/2;
            if(checkIfAllBananasCanBeEatenWithThisMiddleSpeed(middleEatingSpeed))
                maxEatingSpeed = middleEatingSpeed - 1;
            else
                minEatingSpeed = middleEatingSpeed + 1;
        }
        return minEatingSpeed;
    }
    
    public boolean checkIfAllBananasCanBeEatenWithThisMiddleSpeed(double speed){
        double hours = 0;
        for(int pile : piles)
            hours = hours + Math.ceil(pile/speed);
        return hours <= limit;
    }
}