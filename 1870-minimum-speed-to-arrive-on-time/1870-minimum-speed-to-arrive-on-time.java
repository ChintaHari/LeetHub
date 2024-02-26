class Solution {
    double limit;
    public int minSpeedOnTime(int[] dist, double hour) {
        limit = hour;
        if(dist.length > Math.ceil(hour))
            return -1;
        
        int left = 1;
        int right = (int)Math.pow(10, 7);
        
        while(left <= right){
            int mid = left + (right - left)/2;
            if(canReachWithSpeedMid(mid, dist))
                right = mid - 1;
            else
                left = mid + 1;
        }
        return left;
    }
    
    public boolean canReachWithSpeedMid(int speed, int[] dist){
        double hours = 0;
        for(double ele: dist){
            hours = Math.ceil(hours);
            hours = (hours) + ele/speed;
        }
            
        return hours <= limit;
    }
}