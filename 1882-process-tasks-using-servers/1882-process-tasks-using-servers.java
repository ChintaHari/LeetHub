import java.util.PriorityQueue;

public class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int[] result = new int[tasks.length];

        PriorityQueue<int[]> availableServers = new PriorityQueue<>(
            (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);

        PriorityQueue<int[]> unAvailableServers = new PriorityQueue<>(
            (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] != b[1] ? a[1] - b[1] : a[2] - b[2]);

        for (int i = 0; i < servers.length; i++) 
            availableServers.offer(new int[] {servers[i], i});
        

        int time = 0;
        for (int i = 0; i < tasks.length; i++) {
            time = Math.max(time, i);

            while (!unAvailableServers.isEmpty() && unAvailableServers.peek()[0] <= time) {
                int[] server = unAvailableServers.poll();
                availableServers.offer(new int[] {server[1], server[2]});
            }

            if (availableServers.isEmpty()) {
                time = unAvailableServers.peek()[0];
                while (!unAvailableServers.isEmpty() && unAvailableServers.peek()[0] <= time) {
                    int[] server = unAvailableServers.poll();
                    availableServers.offer(new int[] {server[1], server[2]});
                }
            }

            int[] server = availableServers.poll();
            result[i] = server[1];

            unAvailableServers.offer(new int[] {time + tasks[i], server[0], server[1]});
        }

        return result;
    }
}
