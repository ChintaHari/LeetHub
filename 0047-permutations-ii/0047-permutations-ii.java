class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> curr = new ArrayList<>();
    boolean[] visited;
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        visited = new boolean[nums.length];
        backtrack(nums, 0);
        return result;
    }
    
    public void backtrack(int[] nums, int index){
        if(index == nums.length){
            result.add(new ArrayList<>(curr));
            return;
        }
        
        for(int i=0; i<nums.length; i++){
            if(i>0 && nums[i] == nums[i-1] && !visited[i-1])
                continue;
            if(!visited[i]){
                curr.add(nums[i]);
                visited[i] = true;
                backtrack(nums, index+1);
                visited[i] = false;
                curr.remove(curr.size() - 1);
            }
           
        }
    }
}
    