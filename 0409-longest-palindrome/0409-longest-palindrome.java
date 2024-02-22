class Solution {
    public int longestPalindrome(String s) {
         Map<Character, Integer> map = new HashMap<>();
        for(char ch: s.toCharArray())
            map.put(ch, map.getOrDefault(ch,0)+1);
        int maxLength = 0;
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));
        for(char ch: map.keySet())
            maxHeap.add(ch);
        while(!maxHeap.isEmpty()){
            char pop = maxHeap.remove();
            if(map.get(pop) == 1){
                return maxLength + 1;
            }
            if(map.get(pop)%2==0){
                maxLength = maxLength + map.get(pop);
                map.put(pop, 0);
            }
            if(map.get(pop) %2 !=0){
                maxLength = maxLength + map.get(pop)-1;
                map.put(pop, 1);
                maxHeap.add(pop);
            }
                
        }
        return maxLength;
        
    }
}