class Solution {
    HashMap<Character, Integer> hm = new HashMap<>();
    public String customSortString(String order, String s) {
        StringBuffer sb = new StringBuffer();
        
        for(char ch: s.toCharArray())
            hm.put(ch, hm.getOrDefault(ch,0)+1);
        
        for(char ch1: order.toCharArray()){
            for(char ch2: s.toCharArray()){
                if(ch2 == ch1){
                    sb.append(new String(new char[hm.get(ch2)]).replace('\0', ch2));
                    hm.remove(ch2);
                    break;
                }
            }
        }
        
        for(char ch : hm.keySet())
            sb.append(new String(new char[hm.get(ch)]).replace('\0', ch));
        
        return sb.toString();
    }
}