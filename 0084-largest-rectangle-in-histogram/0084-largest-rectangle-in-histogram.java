class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>();
        int maxArea = 0;
        for(int i=0; i<heights.length; i++){
            int start = i;
            while(! stack.isEmpty() && stack.peek()[1] > heights[i]){
                int[] state = stack.pop();
                maxArea = Math.max(maxArea, state[1] * (i - state[0]));
                start = state[0];
            }
            stack.push(new int[]{start, heights[i]});
        }
        
        while(! stack.isEmpty()){
            int state[]= stack.pop();
            maxArea = Math.max(maxArea, state[1] * (heights.length - state[0]));
        }
        
        return maxArea;
    }
}