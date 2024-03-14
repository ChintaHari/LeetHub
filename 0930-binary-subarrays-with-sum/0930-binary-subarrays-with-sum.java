// class Solution {
//     public int numSubarraysWithSum(int[] nums, int goal) {
        
//         int[] prefixSum = new int[nums.length];
//         prefixSum[0] = nums[0];
//         int count = 0;
//         for(int i=1; i<prefixSum.length; i++)
//             prefixSum[i] = prefixSum[i-1] + nums[i];
        
//         for(int left =0; left < prefixSum.length; left++){
//             for(int right = left; right < prefixSum.length; right++){
//                 if(prefixSum[right] - prefixSum[left] + nums[left] == goal)
//                     count++;
//             }
//         }
        
//         return count;
        
//     }
// }


class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> hm = new HashMap<>();
        int currSum = 0;
        int count =0;
        
        for(int num : nums){
            currSum = currSum + num;
            if(currSum == goal)
                count++;
            if(hm.containsKey(currSum - goal))
                count = count + hm.get(currSum - goal);
            hm.put(currSum, hm.getOrDefault(currSum, 0)+1);
        }
        return count;
    }
}

