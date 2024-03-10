class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> first = new HashSet<>();
        Set<Integer> second = new HashSet<>();
        
        for(int ele : nums1)
            first.add(ele);
        
        for(int ele : nums2)
            second.add(ele);
        
        Set<Integer> intersectionSet = new HashSet<>(first);
        intersectionSet.retainAll(second);
       
        return intersectionSet.stream().mapToInt(Integer::intValue).toArray();
    }
}