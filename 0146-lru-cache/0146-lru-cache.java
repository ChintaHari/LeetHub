class LRUCache {
    Map<Integer, Integer> cache;
    LinkedList<Integer> list;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        list = new LinkedList<>();
    }
    
    public int get(int key) {
        if(!cache.containsKey(key))
            return -1;
        
        list.remove(Integer.valueOf(key));
        list.addLast(key);
        return cache.get(key);
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            cache.put(key, value);
            list.remove(Integer.valueOf(key));
            list.addLast(key);
        }
        else{
            if(list.size() == capacity){
                int removeFirst = list.removeFirst();
                cache.remove(removeFirst);
            }
            
            cache.put(key, value);
            list.addLast(key);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */