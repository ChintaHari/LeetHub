class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        
        PriorityQueue<Character> heap = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));
        for(char ch : map.keySet())
            heap.offer(ch);
        
        int maxLength = 0;
        while(!heap.isEmpty()){
            char ch = heap.remove();
            
            if(map.get(ch) == 1)
                return maxLength + 1;
            
            if(map.get(ch) % 2 == 0){
                maxLength = maxLength + map.get(ch);
                map.put(ch, 0);
            }
            
            if(map.get(ch) % 2 != 0){
                maxLength = maxLength + map.get(ch) - 1;
                map.put(ch, 1);
                heap.offer(ch);
            }
        }
        return maxLength;
    }
}