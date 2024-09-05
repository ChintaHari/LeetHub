class Available implements Comparable<Available> {
    int weight;
    int index;

    public Available(int weight, int index) {
        this.weight = weight;
        this.index = index;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public int compareTo(Available other) {
        if (this.weight != other.weight) {
            return this.weight - other.weight;
        } else {
            return this.index - other.index;
        }
    }
}

class Unavailable implements Comparable<Unavailable> {
    int timeServerBecomesFree;
    int weight;
    int index;

    public Unavailable(int timeServerBecomesFree, int weight, int index) {
        this.timeServerBecomesFree = timeServerBecomesFree;
        this.weight = weight;
        this.index = index;
    }

    public int getTimeServerBecomesFree() {
        return timeServerBecomesFree;
    }

    public void setTimeServerBecomesFree(int timeServerBecomesFree) {
        this.timeServerBecomesFree = timeServerBecomesFree;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public int compareTo(Unavailable other) {
        return this.timeServerBecomesFree - other.timeServerBecomesFree;
    }
}

public class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int result[] = new int[tasks.length];

        PriorityQueue<Available> availableServers = new PriorityQueue<>();
        PriorityQueue<Unavailable> unAvailableServers = new PriorityQueue<>();

        for (int i = 0; i < servers.length; i++)
            availableServers.offer(new Available(servers[i], i));

        int time = 0;
        for (int i = 0; i < tasks.length; i++) {
            time = Math.max(time, i);

            if (availableServers.isEmpty())
                time = unAvailableServers.peek().getTimeServerBecomesFree();

            while (!unAvailableServers.isEmpty() 
                    && time >= unAvailableServers.peek().getTimeServerBecomesFree()) {
                Unavailable unavailable = unAvailableServers.poll();
                availableServers.offer(new Available(unavailable.getWeight(), unavailable.getIndex()));
            }

            Available available = availableServers.poll();
            result[i] = available.getIndex();
            unAvailableServers.offer(new Unavailable(time + tasks[i], available.getWeight(), available.getIndex()));
        }

        return result;
    }
}