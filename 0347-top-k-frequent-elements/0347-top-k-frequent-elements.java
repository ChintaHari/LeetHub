class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int ele: nums)
            map.put(ele, map.getOrDefault(ele,0)+1);

        PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> map.get(n1) - map.get(n2));
        for(int key: map.keySet()){
            heap.add(key);
            if(heap.size() > k)
                heap.remove();
        }
        return heap.stream().mapToInt(Integer::intValue).toArray();
    }
}