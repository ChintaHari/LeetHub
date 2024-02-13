class State{
    String node;
    double ratio;
    
    State(String node, double ratio){
        this.node = node;
        this.ratio = ratio;
    }
}

class Solution {
   
    Map<String, Map<String, Double>> graph = new HashMap<>(); 
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        for(int i=0; i<equations.size(); i++){
            String numerator = equations.get(i).get(0);
            String denominator = equations.get(i).get(1);
            
            if(! graph.containsKey(numerator))
                graph.put(numerator, new HashMap<>());
            
            if(! graph.containsKey(denominator))
                graph.put(denominator, new HashMap<>());
            
            graph.get(numerator).put(denominator, values[i]);
            graph.get(denominator).put(numerator, 1 / values[i]);
        }
        
        double[] ans = new double[queries.size()];
        
        for(int i=0; i<queries.size(); i++)
            ans[i] = calculateEquation(queries.get(i).get(0), queries.get(i).get(1));
        
        return ans;
        
    }
    
    public double calculateEquation(String start, String end){
        // Stack<State> stack = new Stack<>();
        Set<String> visited = new HashSet<>();
        Queue<State> queue = new LinkedList<>();
        
        if (!graph.containsKey(start)) {
            return -1;
        }
        
        visited.add(start);
        // stack.push(new State(start, 1));
        queue.offer(new State(start, 1));
        
        while(! queue.isEmpty()){
            State state = queue.poll();
            String node = state.node;
            double ratio = state.ratio;
            
            if(node.equals(end))
                return ratio;
            
            if(graph.containsKey(node)){
                for(String neighbour : graph.get(node).keySet()){
                    if(! visited.contains(neighbour)){
                        visited.add(neighbour);
                        queue.offer(new State(neighbour, ratio * graph.get(node).get(neighbour)));
                    }
                }
            }
        }
        return -1;
    }
}