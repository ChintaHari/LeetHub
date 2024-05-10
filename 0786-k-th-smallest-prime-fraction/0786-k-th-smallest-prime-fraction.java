class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Double.compare(arr[a[0]] / (double) arr[a[1]], arr[b[0]] / (double) arr[b[1]])
        );

        for (int i = 0; i < arr.length - 1; i++) 
            pq.offer(new int[]{i, arr.length - 1});
        

        for (int i = 1; i < k; i++) {
            int[] top = pq.poll();
            int idx1 = top[0];
            int idx2 = top[1];

            if (idx2 - 1 > idx1) {
                pq.offer(new int[]{idx1, idx2 - 1});
            }
        }

        int[] result = pq.poll();
        return new int[]{arr[result[0]], arr[result[1]]};
    }
}
