class Solution {
    Queue<Integer> queue = new LinkedList<>();
    Set<Integer> visited = new HashSet<>();
    List<Integer> arrList = new ArrayList<>();
    public boolean canReach(int[] arr, int start) {
        arrList = Arrays.stream(arr).boxed().collect(Collectors.toList());
        queue.offer(start);
        visited.add(start);
        
        while(! queue.isEmpty()){
            int currIndex = queue.poll();
            if(arrList.get(currIndex) == 0)
                return true;
            
            for(int neighbour : new int[]{currIndex + arrList.get(currIndex), currIndex - arrList.get(currIndex)}){
                if(neighbour >=0 && neighbour < arr.length){
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