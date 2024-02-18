class Solution {
    public int halveArray(int[] nums) {
        // PriorityQueue<Double> heap = new PriorityQueue<>(Comparator.reverseOrder());
        // for(int ele: nums)
        //     heap.add((double) ele);
        // double sum = heap.stream().mapToDouble(Double::doubleValue).sum();
        // double currSum = sum;
        // int ans=0;
        // while(currSum > sum/2){
        //     double maxElement = heap.remove();
        //     heap.add(maxElement/2);
        //     currSum = currSum - maxElement/2;
        //     ans++;
        // }
        // return ans;
        double target = 0;
        PriorityQueue<Double> heap = new PriorityQueue<>(Comparator.reverseOrder());
        
        for (double num: nums) {
            target += num;
            heap.add(num);
        }
        
        target /= 2;
        int ans = 0;
        while (target > 0) {
            ans++;
            double x = heap.remove();
            target -= (x / 2);
            heap.add(x / 2);
        }
        
        return ans;
    }
}