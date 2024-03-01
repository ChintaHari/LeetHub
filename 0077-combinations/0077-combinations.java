class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> curr = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        backtrack(n, k, 1);
        return result;
    }
    
    public void backtrack(int n , int k, int i){
        if(curr.size() == k){
            result.add(new ArrayList<>(curr));
            return;
        }
        
        for(int j=i; j<=n; j++){
            curr.add(j);
            backtrack(n, k, j+1);
            curr.remove(curr.size() -1);
        }
    }
}