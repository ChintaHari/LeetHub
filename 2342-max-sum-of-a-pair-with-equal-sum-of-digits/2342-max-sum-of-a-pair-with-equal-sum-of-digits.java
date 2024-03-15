class Solution {
    public int maximumSum(int[] nums) {
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        int ans = Integer.MIN_VALUE;
        int currSum = 0;
        for(int num : nums)
            hm.computeIfAbsent(sumOfDigits(num), k -> new ArrayList<>()).add(num);
        
       for(int key : hm.keySet()){
           if(hm.get(key).size() > 1){
               Collections.sort(hm.get(key), Collections.reverseOrder());
               ans = Math.max(ans, hm.get(key).get(0) + hm.get(key).get(1));
           }
        }
        return ans == Integer.MIN_VALUE ? -1 : ans;
        
    }
    
    public int sumOfDigits(int num){
        int sum = 0;
        while(num > 0){
            sum = sum + num%10;
            num = num/10;
        }
        return sum;
    }
}