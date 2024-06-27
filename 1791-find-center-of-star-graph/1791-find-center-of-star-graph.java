class Solution {
    public int findCenter(int[][] edges) {
        int numberOfVertices = edges.length + 1;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        for(int[] edge : edges){
            map.computeIfAbsent(edge[0],  k -> new ArrayList()).add(edge[1]);
            map.computeIfAbsent(edge[1],  k -> new ArrayList()).add(edge[0]);
        }
        
       for(int key : map.keySet()){
           if(map.get(key).size() == numberOfVertices - 1)
               return key;
       }
        
        return 0;
    }
}