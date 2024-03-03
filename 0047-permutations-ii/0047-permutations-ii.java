class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> curr = new ArrayList<>();
    boolean[] visited;
    public List<List<Integer>> permuteUnique(int[] nums) {
        visited = new boolean[nums.length];
        backtrack(nums);
        return result;
    }
    
    public void backtrack(int[] nums){
        if(curr.size() == nums.length && !result.contains(curr)){
            result.add(new ArrayList<>(curr));
            return;
        }
        
        for(int i=0; i<nums.length; i++){
            if(visited[i] || (i>0 && nums[i] == nums[i-1] && !visited[i-1]))
                continue;
            curr.add(nums[i]);
            visited[i] = true;
            backtrack(nums);
            visited[i] = false;
            curr.remove(curr.size() - 1);
        }
    }
}
    