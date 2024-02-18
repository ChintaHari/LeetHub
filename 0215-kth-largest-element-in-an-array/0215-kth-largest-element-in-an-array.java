class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        for(int ele: nums)
            heap.add(ele);
        for(int i=0; i<k-1; i++)
            heap.remove();
        return heap.peek();
        
    }
}