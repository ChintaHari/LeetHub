class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefixProduct = new int[n];
        int[] suffixproduct = new int[n];
        int[] result = new int[n];
        int currProd = 1;
        
        prefixProduct[0] = 1;
        for(int i=1; i<n ; i++){
            prefixProduct[i] = currProd * nums[i-1];
            currProd = prefixProduct[i];
        }
        
        currProd = 1;
        suffixproduct[n-1] = 1;
        for(int i=n-2; i>=0; i--){
            suffixproduct[i] = currProd * nums[i+1];
            currProd = suffixproduct[i];
        }
        
        for(int i=0; i<n; i++)
            result[i] = prefixProduct[i] * suffixproduct[i];
        
        return result;        
    }
}