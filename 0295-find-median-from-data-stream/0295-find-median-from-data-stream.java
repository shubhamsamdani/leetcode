class MedianFinder {

    private PriorityQueue<Integer> minHeap = null;
    private PriorityQueue<Integer> maxHeap = null;
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a,b) -> b-a);
    }
    
    public void addNum(int num) {
        if(maxHeap.isEmpty() || num <= maxHeap.peek()){
            maxHeap.add(num);
        } else{
            minHeap.add(num);
        }
        
        balance();
    }
    private void balance(){
        if(minHeap.size() - maxHeap.size() > 1){
            maxHeap.add(minHeap.poll());
        } else if(maxHeap.size() - minHeap.size() > 1){
            minHeap.add(maxHeap.poll());
        }
    }
    public double findMedian() {
        
        if(minHeap.size() > maxHeap.size()){
            return (double) minHeap.peek();
        } else if(maxHeap.size() > minHeap.size()){
            return (double) maxHeap.peek();
        } else{
            int a = minHeap.peek();
            int b = maxHeap.peek();
            
            return (a+b)/2.0;   
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */