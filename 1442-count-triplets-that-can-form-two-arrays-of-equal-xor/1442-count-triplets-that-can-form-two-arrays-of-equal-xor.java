public class Solution {

    public int countTriplets(int[] arr) {
        int[] prefixXOR = new int[arr.length + 1];
        prefixXOR[0] = 0;
        System.arraycopy(arr, 0, prefixXOR, 1, arr.length);
        int size = prefixXOR.length;

        for (int i = 1; i < size; i++) 
            prefixXOR[i] = prefixXOR[i] ^ prefixXOR[i - 1];
    

        int count = 0;

        for (int left = 0; left < size; left++) {
            for (int right = left + 1; right < size; right++) {
                if (prefixXOR[left] == prefixXOR[right]) 
                    count = count + right - left - 1;
                
            }
        }

        return count;
    }
}