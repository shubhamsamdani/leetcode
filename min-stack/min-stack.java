class MinStack {

    class Node {
        int val;
        int min;
        public Node(int val, int min){
            this.val = val;
            this.min = min;
        }
    }
    
    Stack<Node> s1;
    int currMin;
    public MinStack() {
        s1 = new Stack<>();
        currMin = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        currMin = Math.min(val,currMin);
        Node n1 = new Node(val,currMin);
        s1.push(n1);
    }
    
    public void pop() {
        if(s1.isEmpty()){
           return; 
        }
        
        Node n1 = s1.pop();
        if(n1.min <= currMin){
            if(!s1.isEmpty())
                currMin = (s1.peek()).min ;
            else{
                currMin = Integer.MAX_VALUE;
            }
        }
    }
    
    public int top() {
        return (s1.peek()).val;
    }
    
    public int getMin() {
        return currMin;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */