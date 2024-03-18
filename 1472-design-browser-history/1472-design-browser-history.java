class BrowserHistory {
    List<String> browserHistory;
    int currentIndex;

    public BrowserHistory(String homepage) {
        browserHistory = new ArrayList<>();
        browserHistory.add(homepage);
        currentIndex = 0;
    }
    
    public void visit(String url) {
        browserHistory.subList(currentIndex + 1, browserHistory.size()).clear();
        browserHistory.add(url);
        currentIndex++;
    }
    
    public String back(int steps) {
        currentIndex= Math.max(0, currentIndex - steps);
        return browserHistory.get(currentIndex);
    }
    
    public String forward(int steps) {
        currentIndex = Math.min(browserHistory.size() - 1, currentIndex + steps);
        return browserHistory.get(currentIndex);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */