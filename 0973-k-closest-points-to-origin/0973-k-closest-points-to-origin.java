class Solution {
    public int[][] kClosest(int[][] points, int k) {
        List<List<Integer>> pointsLists = Arrays.stream(points)
            .map(innerArray -> Arrays.stream(innerArray).boxed().collect(Collectors.toList()))
            .collect(Collectors.toList());
        
        PriorityQueue<List<Integer>> heap = 
            new PriorityQueue<>((list1, list2) -> {
                int distance1 = (int)(Math.pow(list1.get(0),2) + Math.pow(list1.get(1), 2));
                int distance2 = (int)(Math.pow(list2.get(0),2) + Math.pow(list2.get(1), 2));
                
                return distance2 - distance1;
            }
        );
            
        for(List<Integer> list : pointsLists){
            heap.add(list);
            if(heap.size() > k)
                heap.remove();
        }
        
        return heap.stream().map(innerListInHeap -> innerListInHeap.stream().mapToInt(Integer::intValue).toArray()).toArray(int[][]::new);
        
    }
}