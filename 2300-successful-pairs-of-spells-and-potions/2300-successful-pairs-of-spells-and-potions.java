class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int result[] = new int[spells.length];
        Arrays.sort(potions);
        for(int i=0; i<spells.length; i++){
            double requiredPortionStrength = (double) success/spells[i];
            int left =0, right = potions.length-1;
            while(left <= right){
                int mid = left + (right - left)/2;
                if(requiredPortionStrength > potions[mid])
                    left = mid + 1;
                if(requiredPortionStrength <= potions[mid])
                    right = mid - 1;
            }
            result[i] =  potions.length - left;
        }
        return result;
    }
}