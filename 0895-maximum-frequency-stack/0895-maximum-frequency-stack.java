class FreqStack {
    Map<Integer, Integer> freqMap;
    Map<Integer, Stack<Integer>> groupMap;
    int maxFreq;

    public FreqStack() {
        freqMap = new HashMap<>();
        groupMap = new HashMap<>();
        maxFreq = 0;
    }
    
    public void push(int val) {
        int freq = freqMap.getOrDefault(val, 0) + 1;
        freqMap.put(val, freq);
        
        if(freq > maxFreq)
            maxFreq = freq;
        
        groupMap.computeIfAbsent(freq, k -> new Stack<>()).push(val);
        
    }
    
    public int pop() {
        Stack<Integer> stack  = groupMap.get(maxFreq);
        int val = stack.pop();
        
        freqMap.put(val, freqMap.get(val) - 1);
        
        if(stack.isEmpty()){
            groupMap.remove(maxFreq);
            maxFreq--;
        }
        
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */