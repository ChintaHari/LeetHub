class LRUCache {
    HashMap<Integer, Integer> hm;
    LinkedList<Integer> list;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        list = new LinkedList<>();
        hm = new HashMap<>();
    }
    
    public int get(int key) {
        if(!hm.containsKey(key))
            return -1;
        
        list.remove(Integer.valueOf(key));
        list.addLast(key);
        return hm.get(key);
    }
    
    public void put(int key, int value) {
        if(hm.containsKey(key)){
            hm.put(key, value);
             list.remove(Integer.valueOf(key));
             list.addLast(key);
        }
        else{
            if(list.size() == capacity){
                int removeFirst = list.removeFirst();
                hm.remove(removeFirst);
            }
            list.addLast(key);
            hm.put(key, value);
        }
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */