class Solution {
    public int minimumCardPickup(int[] cards) {
        int ans = Integer.MAX_VALUE;
        Map<Integer, Integer> lastSeen = new HashMap<>();

        for (int right = 0; right < cards.length; right++) {
            int card = cards[right];

            if (lastSeen.containsKey(card)) {
                int left = lastSeen.get(card);
                ans = Math.min(ans, right - left + 1); 
            }
            lastSeen.put(card, right);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
