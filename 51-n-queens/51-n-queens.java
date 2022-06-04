class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        
        char chess[][] = new char[n][n];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                chess[i][j] = '.';
            }
        }
        
        helper(ans,chess,0);
        return ans;
    }
    
    private void helper(List<List<String>> ans,char[][] chess, int row){
        if(row == chess.length){
            ans.add(build(chess));
            return;
        }
        
        for(int j = 0; j < chess.length; j++){
            if(isValid(chess,row,j)){
                chess[row][j] = 'Q';
                helper(ans,chess,row+1);
                chess[row][j] = '.';
            }
        }
    }
    
    private boolean isValid(char[][] chess, int row, int col){
        for(int i = 0; i < chess.length; i++){
            if(chess[row][i] == 'Q' || chess[i][col] == 'Q'){
                return false;
            }
        }
        
        for(int i = row-1, j = col+1; i >= 0 && j < chess.length; i--,j++){
            if(chess[i][j] == 'Q'){
                return false;
            }
        }
        
        for(int i = row-1, j = col-1; i >= 0 && j >= 0; j--, i--){
            if(chess[i][j] == 'Q'){
                return false;
            }
        }
        
        return true;
    }
    
    private List<String> build(char[][] arr){
        List<String> ans = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            ans.add(new String(arr[i]));
        }
        
        return ans;
    }
}