class Solution {
    StringBuilder sb = new StringBuilder();
    List<String> result = new ArrayList<>();
    char[] alphabets = new char[]{'a','b','c'};
    int index =0, lengthOfDesiredString;
    public String getHappyString(int n, int k) {
        lengthOfDesiredString = n;
        backtrack(index);
        
        return k <= result.size() ? result.get(k-1) : "";
    }
    
    public void backtrack(int index){
        if(sb.length() == lengthOfDesiredString){
            result.add(sb.toString());
            return;
        }
        
        for(int i=0; i<alphabets.length; i++){
            if(sb.length() > 0 && alphabets[i] == sb.charAt(sb.length()-1))
                continue;
            sb.append(alphabets[i]);
            backtrack(i);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}