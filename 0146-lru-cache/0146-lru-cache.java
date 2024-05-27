class LRUCache {
    int capacity;
    HashMap<Integer, Integer> cache;
    List<Integer> list ;

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
            list.remove(Integer.valueOf(key));
            list.addLast(key);
            cache.put(key, value);
        }
        else{
            if(list.size() == capacity){
                int removeFirst = list.removeFirst();
                cache.remove(removeFirst);
            }
             list.addLast(key);
            cache.put(key, value);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */