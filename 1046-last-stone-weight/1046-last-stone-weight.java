class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> b - a);
        for(int stone : stones)
            queue.offer(stone);
        
        while(queue.size() > 1){
            int firstMax = queue.poll();
            int secondMax = queue.poll();
            if(firstMax != secondMax)
                queue.offer(firstMax - secondMax);
        }
        
        return queue.size() == 0 ? 0 : queue.poll();
        
    }
}