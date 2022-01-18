class Solution {
    public boolean canPlaceFlowers(int[] arr, int n) {
        int count = n;
        if(arr.length == 1){
            if(n > 0){
                if(arr[0] == 0){
                    return true;
                } else{
                    return false;
                }
            }
        }
        for(int i = 0; i < arr.length; i++){
            if(count == 0) break;
            
            if(i == 0 && arr[i] == 0 && i+1 < arr.length && arr[i+1] == 0){
                arr[i] = 1;
                count--;
                continue;
            }
            
            if(i == arr.length - 1 && i-1 >= 0 && arr[i] == 0 && arr[i-1] == 0){
                arr[i] = 1;
                count-- ;
                continue;
            }
            
            if(i- 1 >= 0 && i + 1 < arr.length){
                if(arr[i] == 0 && arr[i-1] != 1 && arr[i+1] != 1){
                    arr[i] = 1;
                    count-- ;
                }
            }
        }
        
        return count == 0;
    }
}