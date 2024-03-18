class BrowserHistory {
    Stack<String> back, forward;
    String currentpage;
    public BrowserHistory(String homepage) {
        back = new Stack<>();
        forward = new Stack<>();
        this.currentpage = homepage;
    }
    
    public void visit(String url) {
        back.push(currentpage);
        currentpage = url;
        forward.clear();
    }
    
    public String back(int steps) {
        while(! back.isEmpty() && steps-- >0){
            forward.push(currentpage);
            currentpage = back.pop();
        }

        return currentpage;
    }
    
    public String forward(int steps) {
        while(! forward.isEmpty() && steps-- > 0){
            back.push(currentpage);
            currentpage = forward.pop();
        }
        return currentpage;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */