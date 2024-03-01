class Solution {
    HashMap<Character, String> hm = new HashMap<>();
    List<String> result = new ArrayList<>();
    StringBuilder curr = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) 
            return new ArrayList<>();
        
        hm.put('2', "abc");
        hm.put('3', "def");
        hm.put('4', "ghi");
        hm.put('5', "jkl");
        hm.put('6', "mno");
        hm.put('7', "pqrs");
        hm.put('8', "tuv");
        hm.put('9', "wxyz");
        
        backtrack(0, digits);
        
        return result;
    }

    public void backtrack(int index, String digits) {
        if (curr.length() == digits.length()) {
            result.add(curr.toString());
            return;
        }
        
        for (char letter : hm.get(digits.charAt(index)).toCharArray()) {
            curr.append(letter);
            backtrack(index + 1, digits);
            curr.deleteCharAt(curr.length() - 1); 
        }
    }
}
