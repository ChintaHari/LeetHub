class Solution {
    public String getSmallestString(int n, int k) {
        char result[] = new char[n];
        Arrays.fill(result, 'a');
        k = k-n;
        for(int i=result.length-1; i>=0 && k>0; i--){
            int max = Math.min(25, k);
            result[i] = (char)('a' + max);
            k = k - max;
        }
        return new String(result);
        
    }
}