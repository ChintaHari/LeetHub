class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    int[] nums;
    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        backtrack(new ArrayList<>(), 0);
        
        
        return ans;
    }
    
    public void backtrack(List<Integer> curr, int index){
        if(index > nums.length)
            return;
        
        ans.add(new ArrayList<>(curr));
        for(int j = index; j < nums.length; j++){
            curr.add(nums[j]);
            backtrack(curr, j + 1);
            curr.remove(curr.size() - 1);
        }
    }
}