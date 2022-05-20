class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes,(a,b) -> b[1] - a[1]);
        int max = 0;
        
        for(int[] arr: boxTypes){
            if(truckSize - arr[0] >= 0){
                max += arr[0]*arr[1];
                truckSize -= arr[0];
            } else if(arr[0] - truckSize >= 0){
                 max += truckSize*arr[1];
                truckSize = 0;
            }
            
            if(truckSize == 0){
                break;
            }
        }
        
        return max;
    }
}