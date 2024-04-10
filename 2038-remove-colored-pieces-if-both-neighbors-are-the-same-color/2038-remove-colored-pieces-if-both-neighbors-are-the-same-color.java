class Solution {
    public boolean winnerOfGame(String colors) {
        if(colors.length() < 3)
            return false;
        
        int aliceScore=0, bobScore = 0;
        char[] ch = colors.toCharArray();
        for(int i=1; i< ch.length - 1; i++){
            if(ch[i] == ch[i-1] && ch[i] == ch[i+1]){
                if(ch[i] == 'A')
                    aliceScore++;
                else if (ch[i] == 'B')
                    bobScore++;
            }
        }
        return aliceScore > bobScore;
    }
}