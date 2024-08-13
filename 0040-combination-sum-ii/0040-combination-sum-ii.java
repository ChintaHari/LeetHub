class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> curr = new ArrayList<>();
    int currSum = 0, index=0;
    boolean[] visited;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        visited = new boolean[candidates.length];
        backtrack(candidates, currSum, target, index);
        return result;
    }
    
    public void backtrack(int[] candidates, int currSum, int target, int index){
        if(currSum == target){
            result.add(new ArrayList<>(curr));
            return;
        }
        
        for(int i=index; i<candidates.length; i++){
            if (i>index && candidates[i] == candidates[i - 1])
                continue;
            int currentUpdatedSum = currSum + candidates[i];
            if(currentUpdatedSum <= target && !visited[i]){
                curr.add(candidates[i]);
                visited[i] = true;
                backtrack(candidates, currentUpdatedSum, target, i+1);
                visited[i] = false;
                curr.remove(curr.size() - 1);
            }
            
        }
    }
}