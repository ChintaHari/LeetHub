class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        for(int i=0; i<n; i++){
            if(i>0 && nums[i] == nums[i-1])
                continue;
            int j = i+1, k= n-1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0){
                    result.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k])));
                    while(j < k && nums[j] == nums[j+1])
                        j++;
                    while(j<k && nums[k] == nums[k-1])
                        k--;
                    
                    j++;
                    k--;
                }
                else if(sum < 0)
                    j++;
                else
                    k--;
            }
        }
        return result;
    }
}