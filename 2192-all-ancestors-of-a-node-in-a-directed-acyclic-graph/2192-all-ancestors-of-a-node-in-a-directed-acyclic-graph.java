class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<Integer> adjacencyList[] = new ArrayList[n];
        
        for(int i=0; i<n; i++)
            adjacencyList[i] = new ArrayList<>();
        
        int[] indegree = new int[n];
        
        for(int[] edge : edges){
            adjacencyList[edge[0]].add(edge[1]);
            indegree[edge[1]]++;
        }
        
        Queue<Integer> nodesWithZeroIndegree = new LinkedList<>();
        
        for(int i=0; i<indegree.length; i++)
            if(indegree[i] == 0)
                nodesWithZeroIndegree.offer(i);
        
        List<Integer> topologicalOrder = new ArrayList<>();
        
        while(! nodesWithZeroIndegree.isEmpty()){
            int currentNode = nodesWithZeroIndegree.poll();
            topologicalOrder.add(currentNode);
            
            for(int neighbour : adjacencyList[currentNode]){
                indegree[neighbour]--;
                if(indegree[neighbour] == 0)
                    nodesWithZeroIndegree.add(neighbour);
            }
        }
        
        List<List<Integer>> ancestorList = new ArrayList<>();
        List<Set<Integer>> ancestorSetList = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            ancestorList.add(new ArrayList<>());
            ancestorSetList.add(new HashSet<>());
        }
        
        for(int node : topologicalOrder){
            for(int neighbour : adjacencyList[node]){
                ancestorSetList.get(neighbour).add(node);
                ancestorSetList.get(neighbour).addAll(ancestorSetList.get(node));
            }
        }
        
         for (int i = 0; i < ancestorList.size(); i++) {
            ancestorList.get(i).addAll(ancestorSetList.get(i));
            Collections.sort(ancestorList.get(i));
        }
        
         return ancestorList;
        
    }
}