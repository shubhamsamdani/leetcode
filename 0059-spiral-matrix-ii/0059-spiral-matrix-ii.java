class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int row_min = 0, row_max = n-1;
        int col_min = 0, col_max = n-1;
        
        int count = 1;
        while(row_min <= row_max && col_min <= col_max){
            for(int i = col_min; i <= col_max; i++){
                res[row_min][i] = count;
                count++ ;
            }
            
            row_min++ ;
            for(int i = row_min; i <= row_max; i++){
                res[i][col_max] = count;
                count++ ;
            }
            
            col_max-- ;
            for(int i = col_max; i >= col_min; i--){
                res[row_max][i] = count;
                count++ ;
            }
            
            row_max-- ;
            for(int i = row_max; i >= row_min; i--){
                res[i][col_min] = count;
                count++ ;
            }
            
            col_min++ ;
        }
        
        return res;
    }
}