class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        // Set<Integer> set = new HashSet<>();
        // for(int ele : nums1)
        //     set.add(ele);
        // for(int ele : nums2)
        //     if(set.contains(ele))
        //         return ele;
        // return -1;
        
        int first = 0, second = 0;
        while(first < nums1.length  && second < nums2.length){
            if(nums1[first] == nums2[second])
                return nums1[first];
            else if(nums1[first] < nums2[second])
                first++;
            else
                second++;
        }
        return -1;
        
    }
}