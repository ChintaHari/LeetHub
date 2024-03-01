class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> curr = new ArrayList<>();
    int currSum = 0, startIndex=0;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, target, currSum, startIndex);
        return result; 
    }
    
    public void backtrack(int[] candidates, int target, int currSum, int index){
        if(currSum == target){
            result.add(new ArrayList<>(curr));
            return;
        }
        
        for(int j=index; j<candidates.length; j++){
            if(currSum + candidates[j] <= target){
                curr.add(candidates[j]);
                backtrack(candidates, target, currSum + candidates[j], j);
                curr.remove(curr.size() - 1);
            }
        }
    }
}