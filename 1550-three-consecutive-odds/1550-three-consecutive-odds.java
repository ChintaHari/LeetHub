class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;
        for(int i=0; i<arr.length - 2; i++){
            if(arr[i]%2 == 1){
                count++;
                if(arr[i+1]%2==1 && arr[i+2]%2==1)
                    count = count + 2;
                else
                    count = 0;
            }
            
            if(count == 3)
                return true;
        }
        
        return false;
    }
}