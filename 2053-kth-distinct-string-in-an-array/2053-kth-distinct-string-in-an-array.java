class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for(String str : arr)
            map.put(str, map.getOrDefault(str, 0) + 1);
        
        int i = 1;
        for(String key : map.keySet()){
            if(map.get(key) == 1){
                if(i == k)
                    return key;
                else
                    i++;
            }
        }
        return "";
    }
}