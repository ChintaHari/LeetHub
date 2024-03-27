import java.util.*;

public class Solution {
    private Map<Integer, List<Integer>> tree = new HashMap<>();
    private int[] subtreeSizes;

    public int countHighestScoreNodes(int[] parents) {
        int n = parents.length;
        subtreeSizes = new int[n];
        Arrays.fill(subtreeSizes, 1); // Initialize with 1 to include the node itself

        for (int i = 0; i < n; i++) {
            tree.computeIfAbsent(parents[i], k -> new ArrayList<>()).add(i);
        }

        
        computeSubtreeSizes(0);

        long maxScore = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            long score = 1;
            int totalSizeExcludingCurrent = n - 1; 

            for (int child : tree.getOrDefault(i, Collections.emptyList())) {
                score *= subtreeSizes[child];
                totalSizeExcludingCurrent -= subtreeSizes[child];
            }

            if (i != 0) {
                score *= totalSizeExcludingCurrent;
            }

            if (score > maxScore) {
                maxScore = score;
                count = 1;
            } else if (score == maxScore) {
                count++;
            }
        }

        return count;
    }

    private int computeSubtreeSizes(int node) {
        int total = 1; // Count the node itself
        for (int child : tree.getOrDefault(node, Collections.emptyList())) {
            total += computeSubtreeSizes(child); // Add the size of the child's subtree
        }
        subtreeSizes[node] = total;
        return total;
    }

}
