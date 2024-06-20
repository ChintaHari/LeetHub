class Solution {
    int ballsToBePlaced;
    int[] position;
    
    public int maxDistance(int[] position, int m) {
        int result = 0;
        int n = position.length;
        
        this.position = position;
        ballsToBePlaced = m;
        
        Arrays.sort(position);
        
        int left = 1;
        int right = (int) Math.ceil(position[n-1]/(m - 1.0));
        
        while(left <= right){
            int mid = left + (right - left)/2;
            if(canBePlaced(mid)){
                result = mid;
                left = mid + 1;
            }
            else
                right = mid -1;
        }
        return result;
    }
    
        public boolean canBePlaced(int mid){
        int ballsPlacedTillNow = 1;
        int previousBallPosition = position[0];
        
        for(int i=1; i<position.length && ballsPlacedTillNow < ballsToBePlaced; i++){
            int currentBallPosition = position[i];
            if(currentBallPosition - previousBallPosition >= mid){
                ballsPlacedTillNow++;
                previousBallPosition = currentBallPosition;
            }
        }
        
        return ballsPlacedTillNow == ballsToBePlaced; 
    }
}