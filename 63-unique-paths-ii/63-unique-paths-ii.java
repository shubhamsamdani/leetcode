class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        int[][] path = new int[m][n];
        
        if(m == 1 && n == 1){
            if(obstacleGrid[0][0] == 1){
                return 0;
            }
            
            return 1;
        }
        
        helper(obstacleGrid,path,0,0,m,n);
        
        return path[0][0];
    }
    
    public int helper(int[][] grid, int[][] path, int i, int j, int m, int n){
        
        if(i >= m || j >= n){
            return 0;
        }
        
        if(i == m-1 && j == n-1){
            
            if(grid[i][j] == 1){
                return 0;
            }
            
            return 1;
        }
        
        if(path[i][j] != 0){
            return path[i][j];
        }
        
        if(grid[i][j] == 1){
            return 0;
        }
        
        path[i][j] = helper(grid,path,i+1,j,m,n) + helper(grid,path,i,j+1,m,n);
        return path[i][j];
    }
}