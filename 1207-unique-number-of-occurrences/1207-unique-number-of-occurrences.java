class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for(int num : arr)
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        set = new HashSet<>(hm.values());
        return hm.values().size() == set.size();
        
    }
}