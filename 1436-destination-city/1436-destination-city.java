class Solution {
    public String destCity(List<List<String>> paths) {
        Set<String> source = new HashSet<>();
        Set<String> destination = new HashSet<>();
        
        for(List<String> path : paths){
            source.add(path.get(0));
            destination.add(path.get(1));
        }
        
        for(String city : destination){
            if(!source.contains(city))
                return city;
        }
        
        return "";
    }
}