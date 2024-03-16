class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int num : nums)
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        //Collections.sort(hm.values(), Collections.reverseOrder());
        
        int max = hm.values().stream().mapToInt(Integer::intValue).max().getAsInt();
        int ans = 0;
        for(int key : hm.keySet())
            if(hm.get(key) == max)
                ans = ans + hm.get(key);
        return ans;
    }
}