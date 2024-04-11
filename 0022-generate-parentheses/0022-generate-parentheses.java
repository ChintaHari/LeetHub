class Solution {
    int size = 0;
    int left = 0, right = 0;
    List<String> list = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    public List<String> generateParenthesis(int n) {
        this.size = n;
        backtrack(sb, left, right);
        return list;
    }
    
    public void backtrack(StringBuilder sb, int left, int right){
        if(sb.length() == 2 * size){
            list.add(sb.toString());
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