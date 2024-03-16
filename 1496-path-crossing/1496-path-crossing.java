class Solution {
    public boolean isPathCrossing(String path) {
        Set<String> set = new HashSet<>();
        int x =0, y = 0;
        set.add(coordinate(x,y));
        for(char ch : path.toCharArray()){
            if(ch == 'N') y = y+1;
            if(ch == 'S') y = y-1;
            if(ch == 'E') x = x+1;
            if(ch == 'W') x = x-1;
            
            if(set.contains(coordinate(x,y)))
                return true;
            set.add(coordinate(x,y));
        }
        return false;
    }
    
    public String coordinate(int x, int y){
        return "("+x+","+y+")";
    }
}