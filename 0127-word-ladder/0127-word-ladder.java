class State{
    String node;
    int words;
    State(String node, int words){
        this.node = node;
        this.words = words;
    }
}
class Solution {
    Queue<State> queue = new LinkedList<>();
    Set<String> visited = new HashSet<>();
    Set<String> wordSet;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordSet = new HashSet<>(wordList);
        
        if (!wordSet.contains(endWord))
            return 0;

        queue.offer(new State(beginWord, 1));
        visited.add(beginWord);

        while (!queue.isEmpty()) {
            State state = queue.poll();
            String node = state.node;
            int words = state.words;

            if (node.equals(endWord))
                return words;

            for (String neighbour : calculateNeighbours(node)) {
                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    queue.offer(new State(neighbour, words + 1));
                }
            }
        }
        return 0;
    }

    public List<String> calculateNeighbours(String node) {
        List<String> list = new ArrayList<>();
        char[] chars = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

        for (int i = 0; i < node.length(); i++) {
            char[] charArray = node.toCharArray();
            for (char ch = 'a'; ch <= 'z'; ch++) {
                charArray[i] = ch;
                String modifiedWord = new String(charArray);
                if (wordSet.contains(modifiedWord))
                    list.add(modifiedWord);
            }
        }
        return list;
    }
}
