class Solution {
    public int findLucky(int[] arr) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int largestLuckyInteger = -1;
        for(int num : arr)
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        for(int key : hm.keySet())
            if(key == hm.get(key))
                largestLuckyInteger = Math.max(largestLuckyInteger, key);
        return largestLuckyInteger;
    }
}