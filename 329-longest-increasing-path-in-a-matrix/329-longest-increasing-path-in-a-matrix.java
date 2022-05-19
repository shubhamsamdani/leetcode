class Solution {
     
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[][] dp = new int[m][n];
        int[][] direction = {{-1,0},{1,0},{0,-1},{0,1}};
        
        int maxLen = 1;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int currMax = helper(matrix,direction,dp,m,n,i,j);
                maxLen = Math.max(maxLen, currMax);
            }
        }
        
        return maxLen;
    }
    
    
    
    private int helper(int[][] matrix, int[][] direction, int[][] dp, int m, int n, int x, int y){
        if(x < 0 || x >= m || y < 0 || y >= n){
            return 0;
        }
        
        if(dp[x][y] != 0){
            return dp[x][y];
        }
        
        int currMax = 1;
        for(int[] d : direction){
            int xi = x + d[0];
            int yj = y + d[1];
            
            if(xi < 0 || yj < 0 || xi >= m || yj >= n){
                continue;
            }
            
            if(matrix[xi][yj] <= matrix[x][y]){
                continue;
            }
            
            currMax = Math.max(currMax, 1 + helper(matrix,direction,dp,m,n,xi,yj));
        }
        
        dp[x][y] = currMax;
        return currMax;
    }
}