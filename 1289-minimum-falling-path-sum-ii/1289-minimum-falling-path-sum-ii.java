class Solution {
    public int minFallingPathSum(int[][] grid) {
        int[][] memo = new int[grid.length][grid.length];

        int nextMin1C = -1;
        int nextMin2C = -1;

        for (int col = 0; col < grid.length; col++) {
            memo[grid.length - 1][col] = grid[grid.length - 1][col];
            if (nextMin1C == -1 || memo[grid.length - 1][col] <= memo[grid.length - 1][nextMin1C]) {
                nextMin2C = nextMin1C;
                nextMin1C = col;
            } else if (nextMin2C == -1 || memo[grid.length - 1][col] <= memo[grid.length - 1][nextMin2C]) {
                nextMin2C = col;
            }
        }

        for (int row = grid.length - 2; row >= 0; row--) {
            int min1C = -1;
            int min2C = -1;

            for (int col = 0; col < grid.length; col++) {
                if (col != nextMin1C) {
                    memo[row][col] = grid[row][col] + memo[row + 1][nextMin1C];
                } else {
                    memo[row][col] = grid[row][col] + memo[row + 1][nextMin2C];
                }

                if (min1C == -1 || memo[row][col] <= memo[row][min1C]) {
                    min2C = min1C;
                    min1C = col;
                } else if (min2C == -1 || memo[row][col] <= memo[row][min2C]) {
                    min2C = col;
                }
            }

            nextMin1C = min1C;
            nextMin2C = min2C;
        }

        return memo[0][nextMin1C];
    }
}