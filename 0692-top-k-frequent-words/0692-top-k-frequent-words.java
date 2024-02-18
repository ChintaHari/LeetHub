class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String word : words)
            map.put(word, map.getOrDefault(word,0)+1);
        
        PriorityQueue<String> heap =
                    new PriorityQueue<>((word1, word2) ->
                                     (map.get(word1) == map.get(word2)) 
                                      ? word2.compareTo(word1)
                                     : map.get(word1)- map.get(word2));
        for(String key : map.keySet()){
            heap.add(key);
            if(heap.size() > k)
                heap.remove();
        }
        
       List<String> result = new ArrayList<>();
        while (!heap.isEmpty()) {
            result.add(heap.remove());
        }
        Collections.reverse(result); 

        return result;
    }
}