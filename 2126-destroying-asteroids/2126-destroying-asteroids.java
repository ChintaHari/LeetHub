class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long currMass = mass;
        for(int ele: asteroids){
            if(ele > currMass)
                return false;
            currMass += ele;
        }
        return true;
    }
}