class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        Arrays.sort(deck);
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<n; i++)
            queue.offer(i);
        
        int[] revealedOrder = new int[n];
        for(int i=0; i<n; i++){
            revealedOrder[queue.poll()] = deck[i];
            queue.add(queue.poll());
        }
        
        return revealedOrder;
    }
}