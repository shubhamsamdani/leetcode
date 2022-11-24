class Solution {
    public boolean exist(char[][] board, String word) {
        boolean visited[][] = new boolean[board.length][board[0].length];
        
        int n = board.length;
        int m = board[0].length;
        
        char[] w = word.toCharArray();
        for( int i = 0; i < n; i++){
            for( int j = 0; j < m; j++){
                if(board[i][j] == w[0] && isExist(0,i,j,n,m,board,visited,w)){
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean isExist( int p, int i, int j, int n, int m, char[][] board, boolean visited[][], char[] w){
        visited[i][j] = true;
        
        if(p == w.length - 1){
            return true;
        }
        
        if(i > 0 && !visited[i-1][j] && board[i-1][j] == w[p+1] && isExist(p+1,i-1,j,n,m,board,visited,w)){
            return true;
        }
        
        if(j > 0 && !visited[i][j-1] && board[i][j-1] == w[p+1] && isExist(p+1,i,j-1,n,m,board,visited,w)){
            return true;
        }
        
        if(i < n-1 && !visited[i+1][j] && board[i+1][j] == w[p+1] && isExist(p+1,i+1,j,n,m,board,visited,w)){
            return true;
        }
        
        if(j < m-1 && !visited[i][j+1] && board[i][j+1] == w[p+1] && isExist(p+1,i,j+1,n,m,board,visited,w)){
            return true;
        }
        
        visited[i][j] = false;
        
        return false;
    }
}