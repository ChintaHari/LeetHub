class Solution {
    List<List<String>> ans = new ArrayList<>();
    List<String> curr = new ArrayList<>();
    public List<List<String>> partition(String s) {
        backtrack(s, 0);
        return ans;
    }
    
    public void backtrack(String s, int index){
        if(index == s.length()){
            ans.add(new ArrayList<>(curr));
            return;
        }
        
        for(int j = index; j < s.length(); j++){
            if(isPalindrome(s, index, j)){
                curr.add(s.substring(index, j+1));
                backtrack(s, j+1);
                curr.remove(curr.size() - 1);
            }
        }
    }
    
    public boolean isPalindrome(String s, int left, int right){
        while(left < right){
            if(s.charAt(left) != s.charAt(right))
                return false;
            else{
                left++;
                right--;
            }
        }
        return true;
    }
}