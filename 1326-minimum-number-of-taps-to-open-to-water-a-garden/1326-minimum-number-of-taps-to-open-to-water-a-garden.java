class Solution {
    public int minTaps(int n, int[] ranges) {
        int start=0, end=0, taps=0;
        while(end < n){
            for(int i=0; i<ranges.length; i++){
                int leftRange = i - ranges[i];
                int rightRange = i + ranges[i];
                
                if(leftRange <= start && rightRange > end)
                    end = rightRange;
            }
            if(start == end)
                return -1;
            start = end;
            taps++;
            
        }
        return taps;
        
    }
}