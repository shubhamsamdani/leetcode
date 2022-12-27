class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int count = 0;
        int n = rocks.length;
        int[] rem = new int[n];
        
        for(int i = 0; i < n; i++){
            rem[i] = capacity[i] - rocks[i];
        }
        
        Arrays.sort(rem);
        
        int i = 0;
        while(additionalRocks > 0 && i < n){
            if(additionalRocks >= rem[i]){
                additionalRocks -= rem[i];
                count++ ;
            }
            
            i++ ;
        }
        
        return count;
    }
}