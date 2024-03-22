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
        for(int i = nums.length - 2; i>=0 ; i--){
            int farthestPositionThatCanBeReachedByCurrentPosition = Math.min(i + nums[i], nums.length-1);
            for(int nP = i+1; nP <= farthestPositionThatCanBeReachedByCurrentPosition; nP++){
                if(dp[nP]){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }
}