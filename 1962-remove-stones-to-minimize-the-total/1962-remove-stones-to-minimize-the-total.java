class Solution {
    public int minStoneSum(int[] piles, int k) {
          PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        for(int ele: piles)
            heap.add(ele);
        int sum = heap.stream().mapToInt(Integer::intValue).sum();
        int currSum = sum;
        for(int i=0; i<k; i++){
            int currMaxElement = heap.remove();
            heap.add(currMaxElement - currMaxElement/2);
            currSum = currSum - currMaxElement/2;
        }
        return currSum;
        
    }
}