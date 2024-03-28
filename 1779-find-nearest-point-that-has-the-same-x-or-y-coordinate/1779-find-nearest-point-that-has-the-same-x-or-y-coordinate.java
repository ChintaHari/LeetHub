class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int minManhattenDistance = Integer.MAX_VALUE;
        int minIndex = -1;
        for(int i = 0; i< points.length; i++){
            int xi = points[i][0];
            int yi = points[i][1];
            if(xi == x || yi == y){
                int distance = Math.abs(x-xi) + Math.abs(y-yi);
                if(distance < minManhattenDistance){
                    minManhattenDistance = distance;
                    minIndex = i;
                }
            }
        }
        return minIndex;
    }
}