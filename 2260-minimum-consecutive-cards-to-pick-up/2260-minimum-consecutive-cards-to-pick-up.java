class Solution {
    public int minimumCardPickup(int[] cards) {
        HashMap<Integer, Integer> cardsMap = new HashMap<>();
       int left=0, right=1;
       int min = Integer.MAX_VALUE;
       cardsMap.put(cards[0], 1);
       for(right=1; right<cards.length; right++){
           
            while(cardsMap.containsKey(cards[right])){
                min = Math.min(min, right - left + 1);
                cardsMap.put(cards[left], cardsMap.get(cards[left])-1 );
                if(cardsMap.get(cards[left]) == 0)
                    cardsMap.remove(cards[left]);
                left++;
                
            }
             cardsMap.put(cards[right],cardsMap.getOrDefault(cards[right],0) + 1 );   
          
       }
       if(min == Integer.MAX_VALUE)
            return -1;
        else
            return min;
    }
}