class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>( (a,b) -> {
            int distance1 = a[0]*a[0] + a[1]*a[1];
            int distance2 = b[0]*b[0] + b[1]*b[1];
            
            return distance1 - distance2;
        });
        
        for(int[] point : points)
            queue.add(point);
        
        
        int[][] result = new int[k][2];
        for(int i =0; i < k; i++)
            result[i] = queue.remove();
        return result;
    }
}