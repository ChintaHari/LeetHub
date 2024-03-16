class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int ans = 0;
        int left = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int right = 0; right < nums.length; right++){
            hm.put(nums[right], hm.getOrDefault(nums[right], 0) + 1);
            while(left < nums.length && hm.get(nums[right]) > k){
                ans = Math.max(ans, right - left);
                hm.put(nums[left], hm.getOrDefault(nums[left], 0) - 1);
                if(hm.get(nums[left]) < 1)
                    hm.remove(nums[left]);
                left++;
            }
             ans = Math.max(ans, right - left+1);
        }
        return ans;
        
    }
}