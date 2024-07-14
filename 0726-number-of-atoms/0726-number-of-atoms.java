import java.util.regex.*;

class Solution {

    public String countOfAtoms(String formula) {
        
        String regex = "([A-Z][a-z]*)(\\d*)|(\\()|(\\))(\\d*)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(formula);

        Stack<Map<String, Integer>> stack = new Stack<>();
        stack.push(new HashMap<>());

        while (matcher.find()) {
            String atom = matcher.group(1);
            String count = matcher.group(2);
            String left = matcher.group(3);
            String right = matcher.group(4);
            String multiplier = matcher.group(5);

            if (atom != null) {
                stack.peek()
                    .put(
                        atom,
                        stack.peek().getOrDefault(atom, 0) +
                        (count.isEmpty() ? 1 : Integer.parseInt(count))
                    );
            }
            else if (left != null) 
                stack.push(new HashMap<>());
            
            
            else if (right != null) {
                Map<String, Integer> currMap = stack.pop();
                if (!multiplier.isEmpty()) {
                    int mult = Integer.parseInt(multiplier);
                    for (String atomName : currMap.keySet()) {
                        currMap.put(atomName, currMap.get(atomName) * mult);
                    }
                }

                for (String atomName : currMap.keySet()) {
                    stack
                        .peek()
                        .put(
                            atomName,
                            stack.peek().getOrDefault(atomName, 0) +
                            currMap.get(atomName)
                        );
                }
            }
        }

        TreeMap<String, Integer> finalMap = new TreeMap<>(stack.peek());

        StringBuilder ans = new StringBuilder();
        for (String atom : finalMap.keySet()) {
            ans.append(atom);
            if (finalMap.get(atom) > 1) {
                ans.append(finalMap.get(atom));
            }
        }

        return ans.toString();
    }
}