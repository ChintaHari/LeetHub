class Solution {

    public int minimumPushes(String word) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : word.toCharArray()) 
            map.put(c, map.getOrDefault(c, 0) + 1);
        
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        
        queue.addAll(map.values());

        int totalPushes = 0;
        int index = 0;

        while (!queue.isEmpty()) {
            totalPushes += (index / 8 + 1) * queue.poll();
            index++;
        }

        return totalPushes;
    }
}