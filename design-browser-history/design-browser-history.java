class BrowserHistory {
        Stack<String> reverse ;
        Stack<String> forward ;
        String current = "";
    public BrowserHistory(String homepage) {
         reverse = new Stack<>();
         forward = new Stack<>();
            current = homepage;
    }
    
    public void visit(String url) {
        forward.clear();
        reverse.push(current);
        current = url;
        
    }
    // current = "f"
    //r = [l,g]
    // f = [c , b]
    public String back(int steps) {
        if (steps > reverse.size()){
            steps = reverse.size();
        }
        while(steps-- != 0){
            forward.add(current);
            String top = reverse.pop();
            current = top ;
        }
        return current;
    }
    
    public String forward(int steps) {
         if (steps > forward.size()){
            steps = forward.size();
        }
        while(steps-- != 0){
            reverse.add(current);
            String top = forward.pop();
            current = top ;
        }
        return current;
      }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */