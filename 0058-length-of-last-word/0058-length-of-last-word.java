class Solution {
    public int lengthOfLastWord(String s) {
        String[] components = s.split(" ");
        for(int i = components.length -1 ; i>=0; i--){
            if(!components[i].contains(" "))
                return components[i].length();
        }
        return 0;
    }
}