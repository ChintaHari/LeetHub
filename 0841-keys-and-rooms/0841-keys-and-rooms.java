class Solution {
    Set<Integer> visited = new HashSet<>();
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        dfs(0, rooms);
        return visited.size() == rooms.size();
        
    }
    public void dfs(int room, List<List<Integer>> rooms){
        visited.add(room);
        for(int key : rooms.get(room)){
            if(! visited.contains(key))
                dfs(key, rooms);
        }
    }
}