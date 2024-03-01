class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> curr = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);
        return result;
    }
    
    public void backtrack(int[] nums, int i){
        result.add(new ArrayList<>(curr));
        
        if(i > nums.length - 1)
            return;
        
        for(int j=i; j<nums.length; j++){
            curr.add(nums[j]);
            backtrack(nums, j+1);
            curr.remove(curr.size() - 1);
        }
    }
}