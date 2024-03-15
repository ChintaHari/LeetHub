class Solution {
    public List<Integer> intersection(int[][] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        List<Integer> list = Arrays.stream(nums).flatMapToInt(Arrays::stream).boxed().collect(Collectors.toList());
        for(int ele : list)
            hm.put(ele, hm.getOrDefault(ele,0) + 1);
        
        List<Integer> result = new ArrayList<>();
        for(int key : hm.keySet())
            if(hm.get(key) == nums.length)
                result.add(key);
        
        Collections.sort(result);
        return result;
    }
}