class Solution {
    public int videoStitching(int[][] clips, int time) {
        Arrays.sort(clips, (a, b) -> a[0] - b[0]);
        int count = 0, start = 0, end = 0;
        while (end < time) {
           for(int i=0; i<clips.length; i++){
               int left = clips[i][0];
               int right = clips[i][1];
               if(left <=start && right>end)
                   end = right;
           }
            if (start == end) {
                return -1;
            }
            start = end;
            count++;
        }
        return count;
    }
}