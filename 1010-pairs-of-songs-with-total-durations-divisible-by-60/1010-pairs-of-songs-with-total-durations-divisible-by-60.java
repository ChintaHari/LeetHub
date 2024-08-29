class Solution {
    public int numPairsDivisibleBy60(int[] times) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for(int time : times){
            int rem = time % 60;
            int target = 60 - rem;
            if(map.containsKey(target))
                ans = ans + map.get(target);
            if(rem == 0)
                map.put(60, map.getOrDefault(60, 0) + 1);
            else
                map.put(rem, map.getOrDefault(rem, 0) + 1);
        }
        return ans;
        
    }
}