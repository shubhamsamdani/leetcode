class Solution {
    public int minimumDeviation(int[] nums) {
        TreeSet<Integer> set1 = new TreeSet<Integer>();
        for(int num : nums){
            if(num%2 == 1){
                set1.add(num*2);
            } else{
                set1.add(num);
            }
        }
        
        int minDiff = Integer.MAX_VALUE;
        while(true){
            int min = set1.first();
            int max = set1.last();
            
            
            minDiff = Math.min(minDiff, max - min);
            if(max%2 == 0){
                set1.remove(max);
                max /= 2;
                set1.add(max);
            } else{
                break;
            }
            
        }
        
        return minDiff;
    }
}