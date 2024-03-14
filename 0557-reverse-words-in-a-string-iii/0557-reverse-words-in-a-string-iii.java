import java.util.StringTokenizer;

class Solution {
    public String reverseWords(String s) {
        StringTokenizer st = new StringTokenizer(s, " ");
        StringBuilder result = new StringBuilder();
        while(st.hasMoreTokens()){
            StringBuilder sb = new StringBuilder(st.nextToken());
            result.append(sb.reverse().toString());
            if(st.hasMoreTokens())
                result.append(" ");
        }
        return result.toString();
    }
}
