// class Solution {
//     int[] memo, nums;
//     int n;
//     public boolean canJump(int[] nums) {
//         memo = new int[nums.length];
//         Arrays.fill(memo, -1);
//         this.nums = nums;
//         n = nums.length;
//         return canReachEnd(0);
//     }
    
//     public boolean canReachEnd(int position){
//         if(position == n-1)
//             return true;
        
//         if(memo[position] != -1)
//             return memo[position] == 1;
        
//         int farthestPositionThatCanBeReachedByCurrentPosition = Math.min(position + nums[position], n-1);
//         for(int nextPosition = position + 1; nextPosition <= farthestPositionThatCanBeReachedByCurrentPosition; nextPosition++){
//             if(canReachEnd(nextPosition)){
//                 memo[nextPosition] = 1;
//                 return true;
//             }
//         }
        
//         memo[position] = 0;
//         return false;
//     }
// }


//bottom-up appraoch
class Solution {
    public boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[nums.length - 1] = true;
        for(int position = nums.length - 2; position>=0 ; position--){
            int farthestPositionThatCanBeReachedByCurrentPosition = Math.min(position + nums[position], nums.length-1);
            for(int nextPosition = position+1; nextPosition <= farthestPositionThatCanBeReachedByCurrentPosition; nextPosition++){
                if(dp[nextPosition]){
                    dp[position] = true;
                    break;
                }
            }
        }
        return dp[0];
    }
}