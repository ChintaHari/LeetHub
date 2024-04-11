class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String cpdomain : cpdomains){
            String[] splitCpdomains = cpdomain.split(" ");
            int visit = Integer.parseInt(splitCpdomains[0]);
            String[] subdomains = splitCpdomains[1].split("\\.");
            
            StringBuilder sb = new StringBuilder();
            for(int i=subdomains.length - 1; i>=0; i--){
                if(i == subdomains.length - 1)
                    sb.append(subdomains[i]);
                else{
                    sb.insert(0, ".");
                    sb.insert(0, subdomains[i]);
                }
                
                map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + visit);
            }
        }
        
        List<String> result = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            StringBuilder sb = new StringBuilder();
            sb.insert(0, entry.getKey());
            sb.insert(0, " ");
            sb.insert(0, entry.getValue());
            
            result.add(sb.toString());
        }
        
        return result;
    }
}