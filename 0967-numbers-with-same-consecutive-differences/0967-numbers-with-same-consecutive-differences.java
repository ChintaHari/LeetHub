class Solution {
    List<Integer> tempResult = new ArrayList<>();
    public int[] numsSameConsecDiff(int n, int k) {
        for (int i = 1; i <= 9; i++) 
            backtrack(i, n, k);
        return tempResult.stream().mapToInt(Integer::intValue).toArray();
    }
    
     public void backtrack(int currNumber, int n, int k) {
        if (String.valueOf(currNumber).length() == n) {
            tempResult.add(currNumber);
            return;
        }

        int lastDigit = currNumber % 10;
        for (int j = 0; j <= 9; j++) {
            if (Math.abs(lastDigit - j) == k) {
                int newNumber = currNumber * 10 + j; 
                backtrack(newNumber, n, k);
            }
        }
    }
}