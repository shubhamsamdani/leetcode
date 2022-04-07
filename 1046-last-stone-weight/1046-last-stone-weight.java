class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int stone : stones){
            queue.add(stone);
        }
        
        while(queue.size() > 1){
            int y = queue.poll();
            int x = queue.poll();
            
            if(x != y){
                queue.add(y-x);
            }
        }
        
        if(queue.isEmpty()){
            return 0;
        }
        
        return queue.poll();
    }
}