class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int ele: arr)
            map.put(ele, map.getOrDefault(ele,0)+1);
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> map.get(a) - map.get(b));
        for(int key : map.keySet())
            minHeap.add(key);
        
        for(int i=0; i<k ;i++){
            int remove = minHeap.remove();
            map.put(remove, map.getOrDefault(remove,0)-1);
            if(map.get(remove) == 0)
                map.remove(remove);
            else
                minHeap.add(remove);
        }
        return map.keySet().size();
    }
}