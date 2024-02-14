class Solution {
    Queue<Integer> queue = new LinkedList<>();
    Set<Integer> visited = new HashSet<>();
    List<Integer> arrList = new ArrayList<>();
    public boolean canReach(int[] arr, int start) {
        // arrList = Arrays.stream(arr).boxed().collect(Collectors.toList());
        int n = arr.length;
        queue.offer(start);
        visited.add(start);
        
        while(! queue.isEmpty()){
            int currIndex = queue.poll();
            if(arr[currIndex] == 0)
                return true;
            
            int val = arr[currIndex];
            for(int neighbour : new int[]{currIndex + val, currIndex - val}){
                if(neighbour >=0 && neighbour < n){
                    if(! visited.contains(neighbour)){
                        visited.add(neighbour);
                        queue.offer(neighbour);
                    }
                }
            }
        }
        return false;
    }
}