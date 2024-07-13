class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        Integer[] indices = new Integer[positions.length];
        Stack<Integer> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        
        
        for(int i=0; i<positions.length; i++)
            indices[i] = i;
        
        Arrays.sort(indices, (a, b) -> (positions[a] - positions[b]));
        
        for(int currentIndex : indices){
            if(directions.charAt(currentIndex) == 'R')
                stack.push(currentIndex);
            
            else{
                while(!stack.isEmpty() && healths[currentIndex] > 0){
                    int topIndex = stack.pop();
                    if(healths[topIndex] > healths[currentIndex]){
                        healths[topIndex] = healths[topIndex] - 1;
                        healths[currentIndex] = 0;
                        stack.push(topIndex);
                    }
                    
                    else if(healths[topIndex] < healths[currentIndex]){
                        healths[topIndex] = 0;
                        healths[currentIndex] = healths[currentIndex] - 1;
                    }
                    else
                        healths[topIndex] = healths[currentIndex] = 0;
                }
            }
        }
        
        for(int i=0; i<healths.length; i++)
            if(healths[i] > 0)
                result.add(healths[i]);
        
        return result;
    }
}