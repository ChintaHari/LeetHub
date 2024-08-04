class Solution {

    public int rangeSum(int[] nums, int n, int left, int right) {
       PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        
        for (int i = 0; i < n; i++) 
            queue.offer(new int[] { nums[i], i });
        

        int ans = 0, mod = 1000000007;
        for (int i = 1; i <= right; i++) {
            int[] poll = queue.poll();
            if (i >= left)
                ans = (ans + poll[0]) % mod;
            if (poll[1] < n - 1) {
                poll[0] += nums[++poll[1]];
                queue.offer(poll);
            }
        }
        return ans;
    }
}