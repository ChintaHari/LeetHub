

class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int target = n * n;

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[target + 1];
        queue.offer(1);
        visited[1] = true;
        int moves = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();

                if (curr == target) {
                    return moves;
                }

                for (int next = curr + 1; next <= Math.min(curr + 6, target); next++) {
                    int[] coords = getCoordinates(next, n);
                    int row = coords[0];
                    int col = coords[1];

                    int destination = board[row][col] == -1 ? next : board[row][col];

                    if (!visited[destination]) {
                        visited[destination] = true;
                        queue.offer(destination);
                    }
                }
            }
            moves++;
        }

        return -1; 
    }

    private int[] getCoordinates(int num, int n) {
        int row = (num - 1) / n;
        int col = (num - 1) % n;

        if (row % 2 == 1) {
            col = n - 1 - col;
        }

        row = n - 1 - row;

        return new int[]{row, col};
    }
}
