class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> {
            int diff = Math.abs(b - x) - Math.abs(a - x);
            return diff == 0 ? b - a : diff;
        });
        
        for(int point : arr){
            queue.add(point);
            if(queue.size() > k)
                queue.remove();
        }
        
        List<Integer> result = new ArrayList<>(queue);
        Collections.sort(result);
        
        return result;
    }
}