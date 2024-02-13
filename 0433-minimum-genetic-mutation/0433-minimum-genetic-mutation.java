class State{
    String node;
    int mutations;
    
    State(String node, int mutations){
        this.node = node;
        this.mutations = mutations;
    }
}

class Solution {
    //char[] choices = new char[]{'A', 'C', 'G', 'T'};
    Queue<State> queue = new LinkedList<>();
    Set<String> visited = new HashSet<>();
    List<String> bankList = new ArrayList<>();
    public int minMutation(String startGene, String endGene, String[] bank) {
        bankList = Arrays.stream(bank).collect(Collectors.toList());
        System.out.println("bankList: "+bankList);
        queue.offer(new State(startGene, 0));
        visited.add(startGene);
        
        while(! queue.isEmpty()){
            State state = queue.poll();
            String node = state.node;
            int mutations = state.mutations;
            
            if(node.equals(endGene) && bankList.contains(node))
                return mutations;
            
            for(String neighbour : calculateNeighbours(node)){
                if(! visited.contains(neighbour) && bankList.contains(neighbour)){
                    visited.add(neighbour);
                    queue.offer(new State(neighbour, mutations + 1));
                }
            }
        }
        return -1;
    }
    
    public List<String> calculateNeighbours(String node){
        char[] choices = new char[]{'A', 'C', 'G', 'T'};
        List<String> list = new ArrayList<>();
        for(int i=0; i<node.length(); i++){
            StringBuffer sb = new StringBuffer(node);
            for(int j=0; j<choices.length; j++){
                sb.setCharAt(i, choices[j]);
                if(bankList.contains(sb.toString()))
                    list.add(sb.toString());
            }
        }
        System.out.println(list);
        return list;
        
    }
}