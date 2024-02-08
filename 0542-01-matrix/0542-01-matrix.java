import java.util.LinkedList;
import java.util.Queue;

class Solution {
    boolean[][] visited;
    int[][] result;
    int rows = 0, cols = 0;
    int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    Queue<int[]> queue = new LinkedList<>();

    public int[][] updateMatrix(int[][] mat) {
        rows = mat.length;
        cols = mat[0].length;
        visited = new boolean[rows][cols];
        result = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (mat[row][col] == 0) {
                    result[row][col] = 0;
                    visited[row][col] = true;
                    queue.offer(new int[]{row, col});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] currState = queue.poll();
            int currRow = currState[0], currCol = currState[1];

            for (int[] dir : dirs) {
                int nextRow = currRow + dir[0], nextCol = currCol + dir[1];

                if (valid(nextRow, nextCol)) {
                    visited[nextRow][nextCol] = true;
                    result[nextRow][nextCol] = result[currRow][currCol] + 1;
                    queue.offer(new int[]{nextRow, nextCol});
                }
            }
        }

        return result;
    }

    public boolean valid(int nextRow, int nextCol) {
        return nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols && !visited[nextRow][nextCol];
    }
}
