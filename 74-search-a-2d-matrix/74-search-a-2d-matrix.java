class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int j = matrix.length - 1;
        
        int n = matrix.length;
        int m = matrix[0].length - 1;
        while(i < j){
            if(i < n-1 && matrix[i][m] < target){
                i++ ;
            }
            
            if(j > 0 && matrix[j][0] > target){
                j-- ;
            }
        }
        
        if(i == j){
            for( int num : matrix[i]){
                if(num == target){
                    return true;
                }
            }
        } 
        
        return false;
    }
}