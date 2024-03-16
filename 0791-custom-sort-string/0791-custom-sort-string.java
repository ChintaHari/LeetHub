class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for(char ch : s.toCharArray())
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        
        StringBuilder sb = new StringBuilder();
        for(char ch :  order.toCharArray()){
            for(char ch2 : s.toCharArray()){
                if(ch2 == ch){
                    sb.append(new String(new char[hm.get(ch2)]).replace('\0', ch2));
                    hm.remove(ch2);
                    break;
                }
            }
        }
        
        for(char key : hm.keySet())
            sb.append(new String(new char[hm.get(key)]).replace('\0', key));
        
        return sb.toString();
    }
}