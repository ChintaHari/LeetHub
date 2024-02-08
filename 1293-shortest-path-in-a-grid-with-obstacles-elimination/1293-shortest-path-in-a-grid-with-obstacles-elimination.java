import java.util.LinkedList;
import java.util.Queue;

class Solution {
    Queue<int[]> queue = new LinkedList<>();
    int rows = 0, cols = 0;
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

    public int shortestPath(int[][] grid, int k) {
        rows = grid.length;
        cols = grid[0].length;
        boolean[][][] visited = new boolean[rows][cols][k + 1];
        queue.offer(new int[]{0, 0, 0, k});

        while (!queue.isEmpty()) {
            int[] currState = queue.poll();
            int row = currState[0], col = currState[1], steps = currState[2], obstacles = currState[3];

            if (row == rows - 1 && col == cols - 1) {
                return steps;
            }

            for (int[] dir : dirs) {
                int nextRow = row + dir[0], nextCol = col + dir[1];

                if (valid(nextRow, nextCol, grid)) {
                    int nextObstacles = obstacles - grid[nextRow][nextCol];

                    if (nextObstacles >= 0 && !visited[nextRow][nextCol][nextObstacles]) {
                        visited[nextRow][nextCol][nextObstacles] = true;
                        queue.offer(new int[]{nextRow, nextCol, steps + 1, nextObstacles});
                    }
                }
            }
        }

        return -1;
    }

    public boolean valid(int nextRow, int nextCol, int[][] grid) {
        return nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols;
    }
}
