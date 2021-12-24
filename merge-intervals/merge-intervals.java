class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        
        int[][] res = new int[n][2];
        Arrays.sort(intervals, (a,b) -> (a[0] - b[0]));
        // Arrays.sort(intervals, new Comparator<int[]>(){
        //     @Override
        //     public int compare(int[] a, int[] b){
        //         return ((a[0] > b[0]) ? 1 : -1);
        //     }
        // });
        
        int curr = 0;
        res[0][0] = intervals[0][0];
        res[0][1] = intervals[0][1];
        
        for(int i = 1; i < n; i++){
          if(isOverLap(res[curr][0],res[curr][1],intervals[i][0],intervals[i][1])){
                res[curr][0] = Math.min(res[curr][0],intervals[i][0]);
                res[curr][1] = Math.max(res[curr][1],intervals[i][1]);
            }else{
                curr++ ;
                res[curr][0] = intervals[i][0];
                res[curr][1] = intervals[i][1];
            }  
        }
             
        int[][] ans = Arrays.copyOfRange(res, 0, curr+1);
        return ans;     
    }
             
    private boolean isOverLap(int a1, int b1, int a2, int b2){
        if(b1 >= a2){
            return true;
        }
        
        return false;
    }         
}