class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int res[] = new int[k];
        Map<Integer,Integer> map =  new HashMap<>();
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0) + 1);
        }
        
        Map<Integer,List<Integer>> freq = new HashMap<>();
        for(Map.Entry<Integer,Integer> m : map.entrySet()){
            List<Integer> temp = freq.getOrDefault(m.getValue(),new ArrayList<>());
            temp.add(m.getKey());
            freq.put(m.getValue(),temp);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(Map.Entry<Integer,List<Integer>> m : freq.entrySet()){
            pq.add(m.getKey());
        }
        
        int count = 0;
        while(count < k){
            int val = pq.poll();
            List<Integer> temp = freq.get(val);
            for(int num : temp){
                res[count] = num;
                count++ ;
            }
        }
        
        return res;
    }
}