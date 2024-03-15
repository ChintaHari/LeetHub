class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for(char ch : text.toCharArray())
            if(ch == 'b' || ch == 'a' || ch == 'l' || ch == 'o' || ch == 'n')
                hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        int B = hm.getOrDefault('b', 0);
        int A = hm.getOrDefault('a', 0);
        int L = hm.getOrDefault('l', 0)/2;
        int O = hm.getOrDefault('o', 0)/2;
        int N = hm.getOrDefault('n', 0);
        
        return Math.min(Math.min(B, A), Math.min(L, Math.min(O, N)));
        
    }
}