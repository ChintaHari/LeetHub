class Solution {
    public long countSubarrays(int[] nums, int k) {
        int maxElement = Arrays.stream(nums).max().getAsInt();
        long ans = 0;
        int left = 0, maxElementsInWindow = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == maxElement) 
                maxElementsInWindow++;
            
            while (k == maxElementsInWindow) {
                if (nums[left] == maxElement) 
                    maxElementsInWindow--;
                left++;
            }
            ans += left;
        }

        return ans;
    }
}