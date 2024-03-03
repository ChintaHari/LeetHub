class Solution {
    int[] children;
    int index = 0;
    int minUnfairness = Integer.MAX_VALUE;
    public int distributeCookies(int[] cookies, int k) {
        children = new int[k];
        backtrack(cookies, index);
        return minUnfairness;
    }
    
    public void backtrack(int[] cookies, int index){
        if(index == cookies.length){
            int curr = Arrays.stream(children).max().getAsInt();
            minUnfairness = Math.min(minUnfairness, curr);
            return;
        }
        
        for(int i=0; i<children.length; i++){
            children[i] = children[i] + cookies[index];
            backtrack(cookies, index+1);
            children[i] = children[i] - cookies[index];
            
            if(children[i] == 0)
                break;
        }
    }
}