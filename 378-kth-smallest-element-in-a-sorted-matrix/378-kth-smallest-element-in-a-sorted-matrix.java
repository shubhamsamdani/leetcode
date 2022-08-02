class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        
        int n = matrix.length;
        int m = matrix[0].length;
        int low = matrix[0][0];
        int high = matrix[n-1][m-1];
        
        int rank = 0;
        while(low < high){
            int mid = low + (high-low)/2 ;
            rank = getRank(matrix,n,m,mid);
            if(rank < k){
                low = mid+1;
            } else{
                high = mid;
            }
        }
        
        return low;
    }
    
    private int getRank(int[][] matrix, int n, int m, int val){
        int cnt = 0;
        int i = n-1;
        int j = 0;
        
        while(i >= 0 && j < n){
            if(matrix[i][j] > val) i-- ;
            else{
                cnt = cnt + i + 1;
                j++ ;
            }
        }
        
        return cnt;
    }
}