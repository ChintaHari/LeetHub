class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for(char ch : stones.toCharArray())
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        int stonesThatAreAlsoJewels = 0;
        for(char ch : jewels.toCharArray())
            if(hm.containsKey(ch))
                stonesThatAreAlsoJewels = stonesThatAreAlsoJewels + hm.get(ch);
        return stonesThatAreAlsoJewels;
    }
}