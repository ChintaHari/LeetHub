class Solution {
    public int largestAltitude(int[] gain) {
        int max = Integer.MIN_VALUE;
        int[] prefixSum = new int[gain.length + 1];
        prefixSum[0] = 0;
        max = prefixSum[0];
        
        for(int i=0; i<gain.length; i++){
            prefixSum[i+1] = prefixSum[i] + gain[i];
            max = Math.max(max, prefixSum[i+1]);
        }
        return max;
    }
}