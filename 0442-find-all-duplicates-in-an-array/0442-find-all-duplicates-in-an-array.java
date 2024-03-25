class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        for(int i=0; i<n; i++){
            int ele = Math.abs(nums[i]);
            if(nums[ele - 1] < 0)
                result.add(ele);
            nums[ele - 1] = -nums[ele - 1];
        }
        return result;
    }
}