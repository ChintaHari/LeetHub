class Solution {
    public int halveArray(int[] nums) {
        PriorityQueue<Double> heap = new PriorityQueue<>(Comparator.reverseOrder());
        for(int ele: nums)
            heap.add((double) ele);
        double sum = heap.stream().mapToDouble(Double::doubleValue).sum();
        double currSum = sum, target = sum/2;
        int ans=0;
        while(currSum > target){
            double maxElementHalf = heap.remove()/2;
            heap.add(maxElementHalf);
            currSum = currSum - maxElementHalf;
            ans++;
        }
        return ans;
    }
}