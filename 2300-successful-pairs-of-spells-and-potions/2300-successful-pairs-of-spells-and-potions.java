class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        
        int n = spells.length;
        int m = potions.length;
        
        Arrays.sort(potions);
        int[] res= new int[n];
        
        for(int i = 0; i < n; i++){
            int el = spells[i];
            int index = getStrength(Long.valueOf(el), potions, m, success);
            res[i] = m-index ;
        }
        
        return res;
    }
    
    
    private int getStrength(long val, int[] potions, int m, long success){
        int low = 0;
        int high = m-1;
        
        while(low <= high){
            int mid = low + (high-low)/2 ;
            if( val*potions[mid] < success){
                low = mid+1;
            } else{
                high = mid-1;
            }
        }
        
        return low;
    }
}