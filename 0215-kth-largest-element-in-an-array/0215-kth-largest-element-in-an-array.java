class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> b-a);
        for(int num: nums)
            heap.add(num);
        
        for(int i=0; i<k-1; i++)
            heap.remove();
        return heap.remove();
    }
}