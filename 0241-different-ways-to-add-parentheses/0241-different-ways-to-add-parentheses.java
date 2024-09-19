class Solution {
    
    List<Integer>[][] memo;
    String expression;
    public List<Integer> diffWaysToCompute(String expression) {
        int n = expression.length();
        memo = new ArrayList[n][n];
        this.expression = expression;
        return computeResults(0, n - 1);
    }

    private List<Integer> computeResults(int start, int end) {
        
        if (memo[start][end] != null) 
            return memo[start][end];
        

        List<Integer> results = new ArrayList<>();

        if (start == end) {
            results.add(expression.charAt(start) - '0');
            return results;
        }

        if (end - start == 1 && Character.isDigit(expression.charAt(start))) {
            int tens = expression.charAt(start) - '0';
            int ones = expression.charAt(end) - '0';
            results.add(10 * tens + ones);
            return results;
        }

        for (int i = start; i <= end; i++) {
            char currentChar = expression.charAt(i);
            if (Character.isDigit(currentChar)) {
                continue;
            }

            List<Integer> leftResults = computeResults(start, i - 1);
            List<Integer> rightResults = computeResults(i + 1, end);

            for (int leftValue : leftResults) {
                for (int rightValue : rightResults) {
                    switch (currentChar) {
                        case '+':
                            results.add(leftValue + rightValue);
                            break;
                        case '-':
                            results.add(leftValue - rightValue);
                            break;
                        case '*':
                            results.add(leftValue * rightValue);
                            break;
                    }
                }
            }
        }

        memo[start][end] = results;

        return results;
    }
}