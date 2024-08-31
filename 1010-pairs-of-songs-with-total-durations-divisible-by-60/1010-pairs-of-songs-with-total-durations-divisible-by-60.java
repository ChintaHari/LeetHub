// class Solution {
//     public int numPairsDivisibleBy60(int[] times) {
//         Map<Integer, Integer> map = new HashMap<>();
//         int ans = 0;
//         for(int time : times){
//             int rem = time % 60;
//             int target = 60 - rem;
//             if(map.containsKey(target))
//                 ans = ans + map.get(target);
//             if(rem == 0)
//                 map.put(60, map.getOrDefault(60, 0) + 1);
//             else
//                 map.put(rem, map.getOrDefault(rem, 0) + 1);
//         }
//         return ans;
        
//     }
// }

class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int remainders[] = new int[60];
        int count = 0;
        for (int t: time) {
            if (t % 60 == 0) { // check if a%60==0 && b%60==0
                count += remainders[0];
            } else { // check if a%60+b%60==60
                count += remainders[60 - t % 60];
            }
            remainders[t % 60]++; // remember to update the remainders
        }
        return count;
    }
}