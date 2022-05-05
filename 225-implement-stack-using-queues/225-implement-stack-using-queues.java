class MyStack {
    
    LinkedList<Integer> queue;
    int itr;
    
    public MyStack() {
        queue = new LinkedList<>();
        itr = 0;
    }
    
    // O(n)
    public void push(int x) {
        queue.add(x);
        itr += 1;
        int cnt = itr;
        while (cnt > 1) {
            queue.add(queue.remove());      // take all elements from head to n-1 and append it at end 
            cnt -= 1;
        }
    }
    
    // O(1)
    public int pop() {
        int val = top();       
        queue.remove();             // head of list
        itr -= 1;
        return val;
    }
    
    // O(1)
    public int top() {
        return queue.peek();
    }
    
    // O(1)
    public boolean empty() {
        return itr == 0;
    }
}