class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int W = words.length;
        freq = new int[26];
        for (char c: letters) {
            freq[c - 'a']++;
        }
        maxScore = 0;
        check(W - 1, words, score, new int[26], 0);
        return maxScore;
    }

    private boolean isValidWord(int[] subsetLetters) {
        for (int c = 0; c < 26; c++) {
            if (freq[c] < subsetLetters[c]) {
                return false;
            }
        }
        return true;
    }

    private int maxScore;
    private int[] freq;
    
    private void check(int w, String[] words, int[] score, int[] subsetLetters, int totalScore) {
        if (w == -1) {
            maxScore = Math.max(maxScore, totalScore);
            return;
        }
        check(w - 1, words, score, subsetLetters, totalScore);
        
        int L = words[w].length();
        for (int i = 0; i < L; i++) {
            int c = words[w].charAt(i) - 'a';
            subsetLetters[c]++;
            totalScore += score[c];
        }
        
        if (isValidWord(subsetLetters)) {
            check(w - 1, words, score, subsetLetters, totalScore);
        }
        for (int i = 0; i < L; i++) {
            int c = words[w].charAt(i) - 'a';
            subsetLetters[c]--;
            totalScore -= score[c];
        }
    }
}