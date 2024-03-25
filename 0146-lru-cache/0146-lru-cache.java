class LRUCache {
    Map<Integer, Integer> cache;
    LinkedList<Integer> keyLinkedList;
    int capacity;

    public LRUCache(int capacity) {
        cache = new HashMap<>();
        keyLinkedList = new LinkedList<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(!cache.containsKey(key))
            return -1;
        
        keyLinkedList.remove(Integer.valueOf(key));
        keyLinkedList.addLast(key);
        return cache.get(key);
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            cache.put(key, value);
            keyLinkedList.remove(Integer.valueOf(key));
            keyLinkedList.addLast(key);
        }
        else{
            if(keyLinkedList.size() == capacity){
                int removeFirst = keyLinkedList.removeFirst();
                cache.remove(removeFirst);
            }
            
            cache.put(key, value);
            keyLinkedList.addLast(key);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */