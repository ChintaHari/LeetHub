class Solution {
    public int maxDepth(String s) {
        int maxLevel = Integer.MIN_VALUE;
        int currentLevel = 0;
        for(char ch : s.toCharArray()){
            if(ch == '(')
                maxLevel = Math.max(maxLevel, ++currentLevel);  
            else if(ch == ')')
                currentLevel--;
        }
        return maxLevel == Integer.MIN_VALUE ? 0 : maxLevel;
    }
}