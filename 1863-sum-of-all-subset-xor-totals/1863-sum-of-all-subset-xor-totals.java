class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    int[] nums;
    public int subsetXORSum(int[] nums) {
        this.nums = nums;
        backtrack(new ArrayList<>(), 0);
        System.out.println(ans);
        
        int result = 0;
        for (List<Integer> subset : ans) {
            int subsetXORTotal = 0;
            for (int num : subset) 
                subsetXORTotal = subsetXORTotal ^ num;
            
            result = result + subsetXORTotal;
        }
        
        return result;
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