class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            int compliment = target - nums[i];
            if(hm.containsKey(compliment))
                return new int[]{i, hm.get(compliment)};
            hm.put(nums[i], i);
        }
        return new int[]{};
    }
}