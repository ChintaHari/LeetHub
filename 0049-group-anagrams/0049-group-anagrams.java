class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        HashMap<String, List<String>> hm = new HashMap<>();
        for(String s : strs){
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);
            hm.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        
        for(String key : hm.keySet())
            result.add(hm.get(key));
        
        return result;
        
    }
}