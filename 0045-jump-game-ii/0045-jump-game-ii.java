//watch: https://www.youtube.com/watch?v=dJ7sWiOoK7g
// 1D BFS it is.

class Solution {
    public int jump(int[] nums) {
        int left =0, right = 0;
        int farthest = 0;
        int count = 0;
        while(right < nums.length-1){
            farthest = 0;
            for(int i = left; i<=right; i++)
                farthest = Math.max(farthest, i + nums[i]);
            left = right + 1;
            right = farthest;
            count++;
        }
        return count;
    }
}