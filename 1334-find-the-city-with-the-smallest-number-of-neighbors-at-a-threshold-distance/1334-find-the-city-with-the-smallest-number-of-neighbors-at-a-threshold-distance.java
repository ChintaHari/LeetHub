class Solution {

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int INF = (int) 1e9 + 7;
        int[][] distanceMatrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(distanceMatrix[i], INF); 
            distanceMatrix[i][i] = 0; 
        }

        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            int weight = edge[2];
            distanceMatrix[start][end] = weight;
            distanceMatrix[end][start] = weight; 
        }

        floyd(n, distanceMatrix);
        return getCityWithFewestReachable(n, distanceMatrix, distanceThreshold);
    }

    void floyd(int n, int[][] distanceMatrix) {
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    distanceMatrix[i][j] = Math.min(
                        distanceMatrix[i][j],
                        distanceMatrix[i][k] + distanceMatrix[k][j]
                    );
                }
            }
        }
    }

    int getCityWithFewestReachable(int n, int[][] distanceMatrix, int distanceThreshold) {
        int cityWithFewestReachable = -1;
        int fewestReachableCount = n;

        for (int i = 0; i < n; i++) {
            int reachableCount = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) 
                    continue;
                
                if (distanceMatrix[i][j] <= distanceThreshold) 
                    reachableCount++;
                
            }
            if (reachableCount <= fewestReachableCount) {
                fewestReachableCount = reachableCount;
                cityWithFewestReachable = i;
            }
        }
        return cityWithFewestReachable;
    }
}