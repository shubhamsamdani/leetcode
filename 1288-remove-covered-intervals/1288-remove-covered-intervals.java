class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> (a[0] - b[0] == 0 ? b[1] - a[1] : a[0] - b[0]));
        
        int i = 0, j = 1;
        int count = 0;
        int n = intervals.length;
        
        if(n <= 1){
            return n;
        }
        
        while(i < n && j < n){
            int a = intervals[i][0];
            int b = intervals[i][1];
            
            int c = intervals[j][0];
            int d = intervals[j][1];
            
            if(c >= a && b >= d){
                count++ ;
            } else{
                i = j;
            }
            
            j++ ;
        }
        
        return n - count;
    }
}