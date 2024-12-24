class Solution {
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        int n = edges1.length + 1;
        int m = edges2.length + 1;

        List<List<Integer>> adjList1 = buildAdjList(n, edges1);
        List<List<Integer>> adjList2 = buildAdjList(m, edges2);

        int diameter1 = findDiameter(n, adjList1);
        int diameter2 = findDiameter(m, adjList2);

        int combinedDiameter = (int) Math.ceil(diameter1 / 2.0) + (int) Math.ceil(diameter2 / 2.0) + 1;

        return Math.max(Math.max(diameter1, diameter2), combinedDiameter);
    }

    private List<List<Integer>> buildAdjList(int size, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < size; i++) 
            adjList.add(new ArrayList<>());
        
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        return adjList;
    }

    private int findDiameter(int n, List<List<Integer>> adjList) {
        Queue<Integer> leavesQueue = new LinkedList<>();
        int[] degrees = new int[n];
        for (int node = 0; node < n; node++) {
            degrees[node] = adjList.get(node).size();
            if (degrees[node] == 1) 
                leavesQueue.offer(node);
        }

        int remainingNodes = n;
        int leavesLayersRemoved = 0;
        
        while (remainingNodes > 2) {
            int size = leavesQueue.size();
            remainingNodes -= size;
            leavesLayersRemoved++;
            for (int i = 0; i < size; i++) {
                int currentNode = leavesQueue.poll();
                for (int neighbor : adjList.get(currentNode)) {
                    degrees[neighbor]--;
                    if (degrees[neighbor] == 1) 
                        leavesQueue.offer(neighbor);
                }
            }
        }

        if (remainingNodes == 2) 
            return 2 * leavesLayersRemoved + 1;

        return 2 * leavesLayersRemoved;
    }
}