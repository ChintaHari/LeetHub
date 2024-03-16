class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int num : nums)
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        //Collections.sort(hm.values(), Collections.reverseOrder());
        
         int max = Integer.MIN_VALUE;
        for(int ele : hm.values())
            max = Math.max(max, ele);
        int ans = 0;
        for(int key : hm.keySet())
            if(hm.get(key) == max)
                ans = ans + hm.get(key);
        return ans;
    }
}