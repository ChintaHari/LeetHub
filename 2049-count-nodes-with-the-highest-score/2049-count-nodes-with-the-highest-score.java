class Solution {
    int[] subtreeSizes;
    Map<Integer, List<Integer>> parentsToChildrenMap;
    public int countHighestScoreNodes(int[] parents) {
        parentsToChildrenMap = new HashMap<>();
        int n = parents.length;
        for(int i=0; i<n; i++)
            parentsToChildrenMap.computeIfAbsent(parents[i], k -> new ArrayList<>()).add(i);
        
        subtreeSizes = new int[n];
        Arrays.fill(subtreeSizes, -1);
        calculateSubtreeSizesAlongWithItelf(0);
        
        long maxScore = 0;
        int count = 0;
        for(int i=0; i<n; i++){
            long score = 1;
            int totalSizeExcludingCurrentNode = n - 1;
            
            for(int child : parentsToChildrenMap.getOrDefault(i, Collections.emptyList())){
                score = score * subtreeSizes[child];
                totalSizeExcludingCurrentNode = totalSizeExcludingCurrentNode - subtreeSizes[child];
            }
                
            if(i != 0)
                score = score * totalSizeExcludingCurrentNode;
            
            if(score > maxScore){
                maxScore = score;
                count = 1;
            }
            else if(score == maxScore)
                count++;
            
        }
        return count;
    }
    
    public int calculateSubtreeSizesAlongWithItelf(int node){
        int subtreeSizeAlongWithItelf = 1;
        for(int child : parentsToChildrenMap.getOrDefault(node, Collections.emptyList()))
            subtreeSizeAlongWithItelf = subtreeSizeAlongWithItelf + calculateSubtreeSizesAlongWithItelf(child);
        
        subtreeSizes[node] = subtreeSizeAlongWithItelf;
        return subtreeSizes[node];
    }
}