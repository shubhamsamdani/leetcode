class Solution {
    public boolean validMountainArray(int[] arr) {
        if(arr.length < 3){
            return false;
        }
        
        boolean isPeak = false, isDrop = false, isUp = false;;
        int i = 0, n = arr.length;
        while(i+ 1 < n){
            while(i + 1 < n && arr[i] < arr[i+1]){
                i++ ;
                isUp = true;
            }
            
            if(isPeak){
                return false;
            }
            
            isPeak = true;
            while(i + 1 < n && arr[i] > arr[i+1]){
                i++ ;
                isDrop = true;
            }
            
            if(i < n-1){
                return false;
            }
        }
        
        if(!isUp || !isDrop){
            return false;
        }
        
        return true;
    }
}