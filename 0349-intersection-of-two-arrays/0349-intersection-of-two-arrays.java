// class Solution {
//     public int[] intersection(int[] nums1, int[] nums2) {
//         Set<Integer> first = new HashSet<>();
//         Set<Integer> second = new HashSet<>();
        
//         for(int ele : nums1)
//             first.add(ele);
        
//         for(int ele : nums2)
//             second.add(ele);
        
//         Set<Integer> intersectionSet = new HashSet<>(first);
//         intersectionSet.retainAll(second);
       
//         return intersectionSet.stream().mapToInt(Integer::intValue).toArray();
//     }
// }


class Solution{
     public int[] intersection(int[] nums1, int[] nums2) {
         Set<Integer> set = new HashSet<>();
         Arrays.sort(nums1);
         Arrays.sort(nums2);
         int first = 0, second = 0;
         
         while(first < nums1.length && second < nums2.length){
             if(nums1[first] < nums2[second])
                 first ++;
             else if(nums1[first] > nums2[second])
                 second ++;
             else{
                 set.add(nums1[first]);
                 first++;
                 second++;
             }
         }
         
         return set.stream().mapToInt(Integer::intValue).toArray();
         
     }
}

// class Solution {
//     public int[] intersection(int[] nums1, int[] nums2) {
//         Set<Integer> set = new HashSet<>();

//         for(int i=0; i<nums1.length; i++){
//             for(int j=0; j<nums2.length; j++){
//                 if(nums1[i] == nums2[j]) set.add(nums1[i]);
//             }
//         }

//         int[] arr = set.stream().mapToInt(Integer::intValue).toArray();
//         return arr;
//     }
// }