class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> curr = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums);
        return result;
    }
    
    public void backtrack(int[] nums){
        if(curr.size() == nums.length){
            result.add(new ArrayList<>(curr));
            return;
        }
        
        for(int num : nums){
            if(! curr.contains(num)){
                curr.add(num);
                backtrack(nums);
                curr.remove(curr.size() - 1);
            }
        }
    }
}