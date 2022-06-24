class Solution {
    public boolean isPossible(int[] target) {
        long totalSum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> (b - a));
        
        for(int num : target){
            totalSum += num;
            pq.offer(num);
        }
        
        while(!pq.isEmpty()){
            int maxEl = pq.poll();
            long remaining = totalSum - maxEl;
            
            if(maxEl == 1 || remaining == 1){
                return true;
            }
            
            if(remaining == 0 || remaining > maxEl){
                return false;
            }
            
            int updatedTotal = (int)(maxEl % remaining);
            if(updatedTotal == 0){
                return false;
            }
            
            maxEl = updatedTotal;
            pq.offer(maxEl);
            totalSum = maxEl + remaining;
        }
        
        
        return true;
    }
}