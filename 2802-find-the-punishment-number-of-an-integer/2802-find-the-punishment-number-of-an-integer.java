class Solution {
    public boolean findPartitions(int startIndex, int sum, String stringNum, int target, int[][] memo) {
        if (startIndex == stringNum.length()) 
            return sum == target;
        
        if (sum > target)
             return false;

        if (memo[startIndex][sum] != -1)
             return memo[startIndex][sum] == 1;

        boolean partitionFound = false;
        for (int currentIndex = startIndex; currentIndex < stringNum.length(); currentIndex++) {
            String currentString = stringNum.substring(startIndex, currentIndex + 1);
            int addend = Integer.parseInt(currentString);
            partitionFound = partitionFound || findPartitions(currentIndex + 1, sum + addend, stringNum,
                                                                    target, memo);
            if (partitionFound) {
                memo[startIndex][sum] = 1;
                return true;
            }
        }
        memo[startIndex][sum] = 0;
        return false;
    }

    public int punishmentNumber(int n) {
        int punishmentNum = 0;
        for (int currentNum = 1; currentNum <= n; currentNum++) {
            int squareNum = currentNum * currentNum;
            String stringNum = Integer.toString(squareNum);

            int[][] memoArray = new int[stringNum.length()][currentNum + 1];
            for (int[] row : memoArray) {
                java.util.Arrays.fill(row, -1);
            }

            if (findPartitions(0, 0, stringNum, currentNum, memoArray)) 
                punishmentNum += squareNum;
        }
        return punishmentNum;
    }
}