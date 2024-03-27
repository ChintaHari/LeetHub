class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        int result[] = new int[n];
        for(int right = n-1; right >= 0; right--){
            int countOfPeopleThatCurrentPersonCanSeeToHisRight = 0;
            int currentPersonHeight = heights[right];
            
            while(!stack.isEmpty() && currentPersonHeight > stack.peek()){
                countOfPeopleThatCurrentPersonCanSeeToHisRight++;
                stack.pop();
            }
            
            if(!stack.isEmpty())
                countOfPeopleThatCurrentPersonCanSeeToHisRight++;
            
            result[right] = countOfPeopleThatCurrentPersonCanSeeToHisRight;
            stack.push(currentPersonHeight);
        }
        return result;
    }
}