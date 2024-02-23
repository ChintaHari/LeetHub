class Solution {
    public int videoStitching(int[][] clips, int time) {
        int start =0, end=0, total=0;
        while(end < time){
            for(int i=0; i<clips.length; i++){
                int left = clips[i][0];
                int right = clips[i][1];
                if(left <= start && right > end)
                    end = right;
            }
            if (start == end)
                return -1;
            
            start = end;
            total++;
        }
        return total;
    }
}