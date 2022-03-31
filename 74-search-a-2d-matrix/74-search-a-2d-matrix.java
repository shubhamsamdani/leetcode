class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        int low = 0;
        int high = n-1;
        
        while(low < high){
            int mid = low + (high-low)/2 ;
            if(matrix[mid][0] == target){
                return true;
            } else if(matrix[mid][m-1] >= target && matrix[mid][0] < target){
                return binarySearch(matrix[mid], target);
            } else if(matrix[mid][m-1] < target){
                low = mid+1;
            } else{
                high = mid-1;
            }
        }
        
        if(low == high){
            for(int num : matrix[low]){
                if(num == target){
                    return true;
                }
            }
        }
        
        return false;
    }
    
    
    boolean binarySearch(int A[], int x){
        int low = 0;
        int high = A.length-1;
        
        while(low <= high){
            int mid = low + (high-low)/2;
            if(A[mid] == x){
                return true;
            } else if(A[mid] > x){
                high = mid-1;
            } else{
                low = mid+1;
            }
        }
        
        return false;
    }
}