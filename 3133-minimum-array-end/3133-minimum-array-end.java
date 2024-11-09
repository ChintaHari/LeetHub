class Solution {
    public long minEnd(int n, int x) {
        long result = x;
        n--;
        while (n > 0) {
            result = (result + 1) | x;
            n--;
        }

        return result;
    }
}