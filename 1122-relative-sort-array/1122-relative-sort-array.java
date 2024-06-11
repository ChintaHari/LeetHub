class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        List<Integer> remain = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        
        for(int ele : arr2)
            hm.put(ele, 0);
        
        for(int ele : arr1){
            if(hm.containsKey(ele))
                hm.put(ele, hm.getOrDefault(ele, 0) + 1);
            else
                remain.add(ele);
        }
        
        Collections.sort(remain);
        
        for(int ele : arr2)
            for(int i=0; i<hm.get(ele); i++)
                result.add(ele);
        
        result.addAll(remain);
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }   
}
    