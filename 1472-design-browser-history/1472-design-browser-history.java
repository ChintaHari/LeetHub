class DoubleLinkedList{
    String url;
    DoubleLinkedList prev, next;
    
    public DoubleLinkedList(String url){
        this.url = url;
        this.prev = null;
        this.next = null;
    }
}
class BrowserHistory {
    DoubleLinkedList current;
    public BrowserHistory(String homepage) {
        current = new DoubleLinkedList(homepage);
    }
    
    public void visit(String url) {
        DoubleLinkedList newNode = new DoubleLinkedList(url);
        current.next = newNode;
        newNode.prev = current;
        current = newNode;
    }
    
    public String back(int steps) {
        while(current.prev != null && steps-- > 0)
            current = current.prev;
        return current.url;
    }
    
    public String forward(int steps) {
        while(current.next != null && steps-- > 0)
            current = current.next;
        return current.url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */