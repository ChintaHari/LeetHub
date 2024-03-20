class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int minManhattenDistance = Integer.MAX_VALUE;
        int minIndex = -1;
        
        for (int i = 0; i < points.length; i++) {
            if (points[i][0] == x || points[i][1] == y) {
                int currentManhattenDistance = Math.abs(points[i][0] - x) + Math.abs(points[i][1] - y);
                if (currentManhattenDistance < minManhattenDistance) {
                    minManhattenDistance = currentManhattenDistance;
                    minIndex = i;
                }
            }
        }
        
        return minIndex;
    }
}
