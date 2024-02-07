class Solution {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        for(int i = 0; i<n; i++)
            graph.put(i,  new ArrayList<>());
        for(List<Integer> edge: edges)
            graph.computeIfAbsent(edge.get(1), k -> new ArrayList<>()).add(edge.get(0));
         
        System.out.println(graph);
        for(int key: graph.keySet())
            if(graph.get(key).size() == 0)
                list.add(key);
        
        return list;
    }
}