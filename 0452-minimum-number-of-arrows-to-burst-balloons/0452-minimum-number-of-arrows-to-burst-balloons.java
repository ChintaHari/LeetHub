//key point: Sort the points array based on the end coordinates of the balloons (xend). This sorting helps in minimizing the number of arrows since shooting an arrow at the end of a balloon will also burst all overlapping balloons that start before or at this end point.

class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a,b) -> Integer.compare(a[1], b[1]));
        int arrows = 1;
        long positionOfXToWhereTheArrowHasBeenShot = points[0][1];
        
        for(int i=1; i<points.length; i++){
            if(points[i][0] > positionOfXToWhereTheArrowHasBeenShot){
                arrows++;
                positionOfXToWhereTheArrowHasBeenShot = points[i][1];
            }
        }
        return arrows;
        
    }
}