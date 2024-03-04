class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int score = 0;
        int left = 0, right = tokens.length - 1;
        while(left <= right){
            if(power >= tokens[left]){
                score = score + 1;
                power = power - tokens[left];
                left ++;
            }
            
            else if (left < right && score >= 1){
                score = score - 1;
                power = power + tokens[right];
                right --;
            }
            
            else
                return score;
        }
        
        return score;
        
    }
}