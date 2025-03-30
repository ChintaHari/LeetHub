class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> characterToIndex = new HashMap<>();
        for(int i=0; i<s.length(); i++)
            characterToIndex.put(s.charAt(i), i);
        
        List<Integer> partitions = new ArrayList<>();
        
        int startPartition = 0, endParition = 0;
        
        for(int i=0; i<s.length(); i++){
            endParition = Math.max(endParition, characterToIndex.get(s.charAt(i)));
            
            if(i == endParition){
                partitions.add(endParition - startPartition + 1);
                startPartition = i + 1;
            }
        }
        return partitions;
    }
}