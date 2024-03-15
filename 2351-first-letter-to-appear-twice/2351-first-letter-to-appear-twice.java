class Solution {
    public char repeatedCharacter(String s) {
        // HashMap<Character, Integer> hm = new HashMap<>();
        // for(char ch : s.toCharArray()){
        //     if(hm.containsKey(ch))
        //         return ch;
        //     hm.put(ch, hm.getOrDefault(ch,0) + 1);
        // }
        // return 'a';
        
        Set<Character> set = new HashSet<>();
        for(char ch: s.toCharArray()){
            if(set.contains(ch))
                return ch;
            set.add(ch);
        }
        return 'c';
    }
}