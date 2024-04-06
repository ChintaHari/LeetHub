class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        int open = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') 
                open++;
            
            else if (c == ')') {
                if (open == 0) 
                    continue; 
                open--;
            }
            sb.append(c);
        }
        
        System.out.println(sb);
        
        StringBuilder result = new StringBuilder();
        for (int i = sb.length() - 1; i >= 0; i--) {
            if (sb.charAt(i) == '(' && open > 0) {
                open --;
                continue;
            } 
            result.append(sb.charAt(i)); 
        }
        
        return result.reverse().toString();
    }
}

        // StringBuilder sb = new StringBuilder();
        // Stack<Integer> st = new Stack<>();
        // for (int i = 0; i < s.length(); i++) {
        //     switch (s.charAt(i)) {
        //         case '(':
        //             st.push(i);
        //             break;
        //         case ')':
        //             if (!st.isEmpty() && s.charAt(st.peek()) == '(') {
        //                 st.pop();
        //             } else {
        //                 st.push(i);
        //             }
        //             break;
        //     }
        //     sb.append(s.charAt(i));
        // }
        // while (!st.isEmpty()) {
        //     sb.deleteCharAt(st.pop());
        // }
        // return sb.toString();