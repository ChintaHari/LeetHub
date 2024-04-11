class MyHashMap {

    int[] hashTable;
    public MyHashMap() {
        hashTable = new int[(int)Math.pow(10,6) + 1];
        Arrays.fill(hashTable, -1);
    }
    
    public void put(int key, int value) {
        hashTable[key] = value;
    }
    
    public int get(int key) {
        return hashTable[key];
    }
    
    public void remove(int key) {
        hashTable[key] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */