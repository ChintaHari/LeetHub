class BrowserHistory {
    List<String> browser;
    int currentIndex;

    public BrowserHistory(String homepage) {
        browser = new ArrayList<>();
        browser.add(homepage);
        currentIndex = 0;
    }
    
    public void visit(String url) {
        browser.subList(currentIndex + 1, browser.size()).clear();
        browser.add(url);
        currentIndex++;
    }
    
    public String back(int steps) {
        currentIndex = Math.max(0, currentIndex - steps);
        return browser.get(currentIndex);
    }
    
    public String forward(int steps) {
        currentIndex = Math.min(browser.size() -1, currentIndex + steps);
        return browser.get(currentIndex);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */