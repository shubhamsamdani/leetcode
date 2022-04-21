class Solution {
    public int numIslands(char[][] grid) {
        int[][] direction = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        int count = 0;
        int n = grid.length, m = grid[0].length;
        boolean visited[][] = new boolean[n][m];
        int i = 0, j = 0;
        
        for(i = 0; i < n; i++){
            for(j = 0; j < m; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    count++ ;
                    dfs(grid,i,j,visited,direction, n, m);
                }
            }
        }
        
        return count;
    }
    
    
    void dfs(char[][] grid, int row, int col, boolean[][] visited, int[][] direction, int n, int m){
        visited[row][col] = true;
        for(int i = 0; i < 4; i++){
            if(row + direction[i][0] < n && row + direction[i][0] >= 0 
               && col + direction[i][1] < m && col + direction[i][1] >= 0 
               && !visited[row + direction[i][0]][col + direction[i][1]]
               && grid[row + direction[i][0]][col + direction[i][1]] == '1'){
                dfs(grid,row + direction[i][0],col + direction[i][1],visited,direction, n, m);
            }
        }
    }
}