class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int num : nums){
            pq.add(num);
        }
        
        int i = 0;
        while(i < k-1){
            pq.poll();
            i++ ;
        }
        
        return pq.poll();
    }
}