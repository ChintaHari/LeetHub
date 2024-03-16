// class Solution {
//     public int maximumUniqueSubarray(int[] nums) {
//         HashMap<Integer, Integer> hm = new HashMap<>();
//         int ans = 0, currSum = 0, left = 0, right = 0;
//         for(right = 0; right < nums.length; right++){
//            hm.put(nums[right], hm.getOrDefault(nums[right], 0) + 1);
            
//             while(left < nums.length && hm.getOrDefault(nums[right],0) > 1){
//                 //currSum = currSum - nums[right];
//                 ans = Math.max(ans, currSum);
//                 currSum = currSum - nums[left];
//                 hm.put(nums[left], hm.getOrDefault(nums[left], 0) - 1);
//                 if(hm.get(nums[left]) < 1)
//                     hm.remove(nums[left]);
//                 left++;
//             }
            
//             currSum = currSum + nums[right];
//             ans = Math.max(ans, currSum);
//         }
//         return ans;
//     }
// }

    class Solution {
        public int maximumUniqueSubarray(int[] nums) {
            Set<Integer> set = new HashSet<>();
            int sum = 0;
            int max = Integer.MIN_VALUE;
            int i=0, j=0;
            for(j=0; j<nums.length; j++){
                sum = sum + nums[j];
                while(set.contains(nums[j])){
                    sum = sum - nums[i];
                    set.remove(nums[i]);
                    i++;
                }
                set.add(nums[j]);
                max = Math.max(max, sum);
            }
            return max;
        }
    }