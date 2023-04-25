class SmallestInfiniteSet {

    Set<Integer> set = new HashSet<>();
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    public SmallestInfiniteSet() {
        for(int i = 1; i < 1001; i++){
            set.add(i);
            pq.offer(i);
        }
    }
    
    public int popSmallest() {
        if(pq.isEmpty()){
            return -1;
        }
        
        int el = pq.poll();
        set.remove(el);
        
        return el;
    }
    
    public void addBack(int num) {
        if(set.contains(num)){
            return;
        }
        
        set.add(num);
        pq.offer(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */