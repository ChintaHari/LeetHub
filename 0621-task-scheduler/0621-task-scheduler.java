class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> taskCountMap = new HashMap<>();
        
        for(char ch : tasks)
            taskCountMap.put(ch, taskCountMap.getOrDefault(ch, 0)+1);
        
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> b-a);
        
        for(char key : taskCountMap.keySet())
            queue.offer(taskCountMap.get(key));
        
        int currentTime = 0;
        Map<Integer, Integer> coolDownMap = new HashMap<>();
        
        while(! queue.isEmpty() || !coolDownMap.isEmpty()){
            if(coolDownMap.containsKey(currentTime - n - 1))
                queue.offer(coolDownMap.remove(currentTime - n - 1));
            
            if(!queue.isEmpty()){
                int left = queue.poll() - 1;
                if(left != 0)
                    coolDownMap.put(currentTime, left);
            }
            currentTime++;
        }
        return currentTime;
    }
}