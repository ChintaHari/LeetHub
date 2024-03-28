class Solution {
    int[] subtreeSizes;
    Map<Integer, List<Integer>> parentsToChildMap;
    int n;
    public int countHighestScoreNodes(int[] parents) {
        parentsToChildMap = new HashMap<>();
        int count = 0; 
        long maxScore = Long.MIN_VALUE;
        n = parents.length;
        
        for(int i=0; i<n; i++)
            parentsToChildMap.computeIfAbsent(parents[i], k -> new ArrayList<>()).add(i);
        
        subtreeSizes = new int[n];
        computeSubtreeSizes(0);
        
        for(int i=0; i<n; i++){
            int totalSizeExcludingItself = n-1;
            long score = 1;
            
            for(int child : parentsToChildMap.getOrDefault(i, Collections.emptyList())){
                score = score * subtreeSizes[child];
                totalSizeExcludingItself = totalSizeExcludingItself - subtreeSizes[child];
            }
            
            if(i != 0){
                score = score * totalSizeExcludingItself;
            }
            
            if(score > maxScore){
                maxScore = score;
                count = 1;
            }
            else if(score == maxScore)
                count++;
        }
        return count;
    }
    
    public int computeSubtreeSizes(int node){
        int subtreeSizeAlongWithItself = 1;
        for(int child : parentsToChildMap.getOrDefault(node, Collections.emptyList()))
            subtreeSizeAlongWithItself = subtreeSizeAlongWithItself + computeSubtreeSizes(child);
        
        subtreeSizes[node] = subtreeSizeAlongWithItself;
        return subtreeSizes[node];
    }
}