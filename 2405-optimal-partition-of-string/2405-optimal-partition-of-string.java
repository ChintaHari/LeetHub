class Solution {
    public int partitionString(String s) {
       Set<Character> set = new HashSet<>();
        int ans=0;
        for(char ch : s.toCharArray()){
            if(set.contains(ch)){
                ans++;
                set = new HashSet<>();
            }
            set.add(ch);
        }
        return ans + (set.isEmpty() ? 0 : 1);
        
    }
}