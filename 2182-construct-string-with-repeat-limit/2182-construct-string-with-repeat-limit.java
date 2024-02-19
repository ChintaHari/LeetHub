class Solution {
    public String repeatLimitedString(String s, int repeatLimit){
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray())
            map.put(ch, map.getOrDefault(ch,0)+1);
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((ch1, ch2) -> ch2.compareTo(ch1));
        maxHeap.addAll(map.keySet());
        StringBuilder sb = new StringBuilder();
        while(! maxHeap.isEmpty()){
            char currChar = maxHeap.poll();
            int currCharFrequencey = map.get(currChar);
            int useFrequency = Math.min(currCharFrequencey, repeatLimit);
            for(int i=0; i<useFrequency; i++)
                sb.append(currChar);
            
            map.put(currChar, currCharFrequencey - useFrequency);
            
            
            if(map.get(currChar) > 0){
                if(maxHeap.isEmpty())
                    break;
                
                char nextChar = maxHeap.poll();
                sb.append(nextChar);
                map.put(nextChar, map.get(nextChar) - 1);
                
                if(map.get(nextChar) > 0)
                    maxHeap.add(nextChar);
                
                maxHeap.add(currChar);
            }
            
        }
        return sb.toString();
        
    }
}