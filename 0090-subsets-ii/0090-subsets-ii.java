class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int[] nums;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        this.nums = nums;
        Arrays.sort(nums);
        backtrack(new ArrayList<>(), 0);
        return result;
    }
    
    public void backtrack(List<Integer> currentSubset, int start){
        result.add(new ArrayList<>(currentSubset));
        
        for(int i=start; i<nums.length; i++){
            if(i > start && nums[i] == nums[i-1])
                continue;
            
            currentSubset.add(nums[i]);
            backtrack(currentSubset, i+1);
            currentSubset.remove(currentSubset.size() - 1);
        }
    }
}