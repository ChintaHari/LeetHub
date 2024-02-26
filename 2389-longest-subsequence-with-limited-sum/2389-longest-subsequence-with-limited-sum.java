class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int prefix[] = new int[nums.length];
        prefix[0] = nums[0];
        for(int i=1; i<prefix.length; i++)
            prefix[i] = nums[i] + prefix[i-1];
        int[] result = new int[queries.length];
        for(int i=0; i<queries.length; i++){
            int targetSum = queries[i];
            int left =0, right = nums.length-1;
            while(left <= right){
                int mid = left + (right - left)/2;
                if(prefix[mid] == targetSum){
                    left = mid + 1;
                    break;
                }
                if(prefix[mid] > targetSum){
                    right = mid - 1;
                }
                else
                    left = mid + 1;
            }
            result[i] = left; //because it is length
        }
        
    return result;
        
    }
}