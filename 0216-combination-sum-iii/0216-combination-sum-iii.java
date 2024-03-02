// class Solution {
//     //List<List<Integer>> result = new ArrayList<>();
//     Set<Set<Integer>> result = new HashSet<>();
//     List<Integer> curr = new ArrayList<>();
//     public List<List<Integer>> combinationSum3(int k, int n) {
//         for(int i=1; i<=9; i++)
//             backtrack(i,k,n,0);
//         return result.stream()
//         .map(ArrayList::new)
//         .collect(Collectors.toList());
//     }
    
//     public void backtrack(int i, int k, int n, int currSum){
//         if(curr.size() == k && currSum == n){
//             result.add(new HashSet<>(curr));
//             return;
//         }
        
//         for(int j=i; j<=9; j++){
//             if(currSum + j <= n){
//                 curr.add(j);
//                 backtrack(j+1, k, n, currSum + j);
//                 curr.remove(curr.size() - 1);
//             }
//         }
//     }
// }



class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> curr = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(1, k, n, 0);
        return result;
    }
    
    public void backtrack(int start, int k, int n, int currSum) {
        if (curr.size() == k && currSum == n) {
            result.add(new ArrayList<>(curr));
            return;
        }
        if (curr.size() > k || currSum > n) {
            return;
        }
        
        for (int j = start; j <= 9; j++) {
            curr.add(j);
            backtrack(j + 1, k, n, currSum + j);
            curr.remove(curr.size() - 1);
        }
    }
}
