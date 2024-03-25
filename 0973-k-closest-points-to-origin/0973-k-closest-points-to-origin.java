class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> {
            int difference1 = a[0]*a[0] + a[1]*a[1];
            int difference2 = b[0]*b[0] + b[1]*b[1];
            
            return difference1 - difference2;
        });
        
        for(int[] point : points)
            queue.add(point);
        
        int[][] result = new int[k][2];
        for(int i=0; i<result.length; i++)
            result[i] = queue.remove();
        return result;
        
    }
}