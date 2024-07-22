class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        
        for (int i = 0; i < names.length; i++) 
            pq.offer(new int[]{i, heights[i]});
        
        String[] sortedNames = new String[names.length];
        int index = 0;
        while (!pq.isEmpty()) 
            sortedNames[index++] = names[pq.poll()[0]];
        
        return sortedNames;
    }
}