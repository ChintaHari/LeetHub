class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int num : nums)
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        
        Integer[] temp = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) 
            temp[i] = nums[i];
        
        Arrays.sort(temp, (a, b) -> {
                        if(hm.get(a) == hm.get(b))
                            return Integer.compare(b,a);
                        return Integer.compare(hm.get(a), hm.get(b));
        });
        
         for (int i = 0; i < nums.length; i++) 
            nums[i] = temp[i];
        
        return nums;
    }
}