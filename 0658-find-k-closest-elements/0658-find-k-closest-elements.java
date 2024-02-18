class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(
            (a,b) -> {
                // int diff = Math.abs(b-x) - Math.abs(a-x);
                // return diff !=0 ? diff : b-a;
                int diff = Math.abs(b-x) - Math.abs(a-x);
                return diff !=0 ? diff : b-a;
            }
        );
        for(int ele: arr){
            heap.add(ele);
            if(heap.size() > k)
                heap.remove();
        }
        List<Integer> ans = new ArrayList<>(heap);
        Collections.sort(ans);
        return ans;
}
}