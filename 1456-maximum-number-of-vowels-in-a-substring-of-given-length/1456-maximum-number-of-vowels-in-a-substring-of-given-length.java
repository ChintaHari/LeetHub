class Solution {
    public int maxVowels(String s, int k) {
        int ans = 0;
        for(int i=0; i<k; i++)
            if(isVowel(s.charAt(i)))
                ans++;
        int currentMax = ans;
        for(int i=k; i<s.length(); i++){
            if(isVowel(s.charAt(i-k)))
                ans--;
            if(isVowel(s.charAt(i)))
                ans++;
            currentMax = Math.max(currentMax, ans);
        }
        return currentMax;
    }
    
    public boolean isVowel(char ch){
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
            return true;
        else
            return false;
    }
}