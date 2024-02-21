class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        for(int ele : arr)
            map.put(ele, map.getOrDefault(ele,0)+1);
            
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));
        for(int key: map.keySet())
            maxHeap.add(key);
        
        int currNoOfElements = n;
        int minSet = 0;
        while(currNoOfElements > n/2){
            int pop = maxHeap.remove();
            currNoOfElements = currNoOfElements - map.get(pop);
            minSet++;
        }
        return minSet;
        
    }
}