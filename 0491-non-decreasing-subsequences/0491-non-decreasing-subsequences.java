class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> curr = new ArrayList<>();
    int index = 0;
    public List<List<Integer>> findSubsequences(int[] nums) {
        //Arrays.sort(nums);
        backtrack(nums, index);
        return result;
    }
    
    public void backtrack(int[] nums, int index){
        if(curr.size() >= 2){
            result.add(new ArrayList<>(curr));
        }
        Set<Integer> set = new HashSet<>();
        for(int i=index; i<nums.length; i++){
            if((!curr.isEmpty() && nums[i] < curr.get(curr.size()-1)) || set.contains(nums[i]))
                continue;
            curr.add(nums[i]);
            set.add(nums[i]);
            backtrack(nums, i + 1);
            curr.remove(curr.size() - 1);
            
        }
    }
}