class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for(int ele : nums1)
            set.add(ele);
        for(int ele : nums2)
            if(set.contains(ele))
                return ele;
        return -1;
        
    }
}