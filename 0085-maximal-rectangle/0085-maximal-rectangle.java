class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int rows = matrix.length, cols = matrix[0].length;
        int[] heights = new int[cols];
        int maxArea = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == '1') 
                    heights[col] += 1;
                else 
                    heights[col] = 0;
            }
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        return maxArea;
    }

    private int largestRectangleArea(int[] heights) {
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
