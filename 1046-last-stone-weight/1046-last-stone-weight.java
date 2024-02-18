class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        for(int ele: stones)
            heap.add(ele);
        
        while(heap.size() > 1){
            int firstMax = heap.remove();
            int secondMax = heap.remove();
            if(firstMax != secondMax)
                heap.add(firstMax - secondMax);
        }
        return heap.size() == 0 ? 0 : heap.remove();
    }
}