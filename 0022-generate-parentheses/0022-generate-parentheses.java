class Solution {
    List<String> result = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    int size, left = 0, right = 0;
    public List<String> generateParenthesis(int n) {
        size = n;
        backtrack(sb, left, right);
        return result; 
    }
    public void backtrack(StringBuilder sb, int left, int right){
        if(sb.length() == 2 * size){
            result.add(sb.toString());
            return;
        }
        
        if(left < size){
            sb.append("(");
            backtrack(sb, left + 1, right);
            sb.deleteCharAt(sb.length() - 1);
        }
        
        if(left > right){
            sb.append(")");
            backtrack(sb, left, right + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}