class Solution {
    public int pivotInteger(int n) {
        
        int prefixSum[] = new int[n+1];
        prefixSum[1] = 1;
        int pivot = -1;
        int left = 1, right = n;
        
        for(int i=2; i<=n; i++)
            prefixSum[i] = prefixSum[i-1] + i;
        
       while(left <= right){
           int leftSum = prefixSum[right] - prefixSum[left] + left;
           int rightSum = prefixSum[n] - prefixSum[right] + right;
           
           if(leftSum == rightSum)
               return right;
           else
               right--;
       }
        
        return pivot;
        
    }
}