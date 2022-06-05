class Solution {
    public int totalNQueens(int n) {
        Set<List<String>> set = new HashSet<>();
        char[][] chess = new char[n][n];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                chess[i][j] = '.';   
            }
        }
        
        helper(set,chess,0);
        return set.size();
    }
                
    private void helper(Set<List<String>> set, char[][] chess, int row){
        if(row == chess.length){
            set.add(buildList(chess));
            return;
        }
        
        for(int i = 0; i < chess.length; i++){
            if(isValid(chess,row,i)){
                chess[row][i] = 'Q';
                helper(set,chess,row+1);
                chess[row][i] = '.';
            }
        }
    }
          
    private boolean isValid(char[][] chess, int row, int col){
        for(int i = 0; i < chess.length; i++){
            if(chess[i][col] == 'Q' || chess[row][i] == 'Q'){
                return false;
            }
        }
        
        for(int i = row, j = col; i >= 0 && j < chess.length; i--,j++){
            if(chess[i][j] == 'Q'){
                return false;
            }
        }
        
        for(int i = row, j = col; i >= 0 && j >= 0; i--,j--){
             if(chess[i][j] == 'Q'){
                return false;
            }
        }
        
        return true;
    }
                
    private List<String> buildList(char[][] chess){
        List<String> ans = new ArrayList<>();
        for(char[] arr : chess){
            ans.add(new String(arr));
        }
        
        return ans;
    }
}