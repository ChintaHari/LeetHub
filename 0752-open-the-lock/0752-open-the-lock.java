class State{
    String node;
    int steps;
    State(String node, int steps){
        this.node = node;
        this.steps = steps;
    }
}
class Solution {
    Queue<State> queue = new LinkedList<>();
    Set<String> visited = new HashSet<>();
    public int openLock(String[] deadends, String target) {
        for(String deadend : deadends){
            if(deadend.equals("0000"))
                return -1;
            visited.add(deadend);
        }
        
        queue.offer(new State("0000", 0));
        visited.add("0000");
        
        while(! queue.isEmpty()){
            State state = queue.poll();
            String node = state.node;
            int steps = state.steps;
            
            if(node.equals(target))
                return steps;
            
            for(String neighbour : calculateNeighbors(node)){
                if(! visited.contains(neighbour)){
                    visited.add(neighbour);
                    queue.offer(new State(neighbour, steps + 1));
                }
            }
        }
        return -1;
    }
    
  public List<String> calculateNeighbors(String node) {
    List<String> list = new ArrayList<>();
    for (int i = 0; i < 4; i++) {
        char[] digits = node.toCharArray();
        digits[i] = (char) ((digits[i] - '0' + 1) % 10 + '0');
        list.add(new String(digits));
        
        digits[i] = node.charAt(i);
        
        digits[i] = (char) ((digits[i] - '0' + 9) % 10 + '0'); 
        list.add(new String(digits));
    }
    
    return list;
}


}