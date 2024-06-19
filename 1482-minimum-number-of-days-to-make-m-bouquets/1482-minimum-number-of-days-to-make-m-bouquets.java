class Solution {
    int[] bloomDay;
    int m, k;
    public int minDays(int[] bloomDay, int m, int k) {
        int left = 0;
        int right = Arrays.stream(bloomDay).max().getAsInt();
        
        this.bloomDay = bloomDay;
        this.m = m;
        this.k = k;
        
        int minDays = -1;
        
        while(left <= right){
            int mid = (left + right)/2;
            if(getNumberOfBoquets(mid) >= m){
                minDays = mid;
                right = mid -1;
            }
            else
                left = mid + 1;
            
        }
        return minDays;
    }
    
    public int getNumberOfBoquets(int mid){
        int count=0, numberOfBoquets = 0;
        
        for(int i=0; i<bloomDay.length; i++){
            if(bloomDay[i] <= mid)
                count++;
            else
                count = 0;
            
            if(count == k){
                numberOfBoquets++;
                count = 0;
            }
        }
        
        return numberOfBoquets;
    }
}