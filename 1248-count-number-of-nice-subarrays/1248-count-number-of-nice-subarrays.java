class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0,1);
        
        int ans = 0, currCountOfOddNumbers = 0;
        for(int num : nums){
            currCountOfOddNumbers = currCountOfOddNumbers + (num % 2);
            if(hm.containsKey(currCountOfOddNumbers - k))
                ans = ans + hm.get(currCountOfOddNumbers - k);
            hm.put(currCountOfOddNumbers, hm.getOrDefault(currCountOfOddNumbers, 0) + 1);
        }
        return ans;
        
    }
}