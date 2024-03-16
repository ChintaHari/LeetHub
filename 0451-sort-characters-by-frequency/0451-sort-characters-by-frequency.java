class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for(char ch : s.toCharArray())
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
       
        List<Integer> list = new ArrayList<>(hm.values());
        Collections.sort(list, Collections.reverseOrder());
        
        StringBuilder sb = new StringBuilder();
        for(Integer num : list){
            for(Map.Entry<Character, Integer> entry : hm.entrySet()){
                if(entry.getValue() == num){
                    sb.append(new String(new char[entry.getValue()]).replace('\0', entry.getKey()));
                    hm.put(entry.getKey(), -1);
                }
            }
        }
        
        return sb.toString();
        
        
    }
}