public class Solution {

    public int findChampion(int n, int[][] edges) {
        int[] indegree = new int[n];
        int champ = -1,  champCount = 0;

        for (int[] edge : edges) 
            indegree[edge[1]]++;

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                champCount++;
                champ = i;
            }
        }
        return champCount > 1 ? -1 : champ;
    }
}