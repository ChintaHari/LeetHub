class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<String, Set<Character>> squares = new HashMap<>();

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char number = board[r][c];
                if (number == '.') continue;

                String blockKey = (r / 3) + "-" + (c / 3);
                
                rows.computeIfAbsent(r, k -> new HashSet<>());
                cols.computeIfAbsent(c, k -> new HashSet<>());
                squares.computeIfAbsent(blockKey, k -> new HashSet<>());

                if (rows.get(r).contains(number) 
                    || cols.get(c).contains(number) || squares.get(blockKey).contains(number)) {
                    return false;
                }

                rows.get(r).add(number);
                cols.get(c).add(number);
                squares.get(blockKey).add(number);
            }
        }

        return true;
    }
}
