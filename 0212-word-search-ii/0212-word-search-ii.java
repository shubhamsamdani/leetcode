class Solution {
    private class TrieNode{
        TrieNode[] children = null;
        String word;
        
        public TrieNode(){
            children = new TrieNode[26];
        }            
    }
    
    public List<String> findWords(char[][] board, String[] words) {
         List<String> res = new ArrayList<>();
         int n = board.length;
         int m = board[0].length;
         if(n==0 || m ==0){
             return new ArrayList<>();
         }
         
        TrieNode root = buildTrie(words);
        for( int i = 0; i < n; i++){
            for( int j = 0; j < m; j++){
                dfs(i,j,board,root,res);
            }
        }
        
        return res;
    }
    
    private void dfs( int i, int j, char[][] board, TrieNode p, List<String> res){
        char c = board[i][j];
        if( c == ';' || p.children[c - 'a'] == null) return;
        p = p.children[c - 'a'];
        if(p.word != null){
            res.add(p.word);
            p.word = null;
        }
        
        board[i][j] = ';';
        if( i > 0){
            dfs(i-1,j,board,p,res);
        }
        
        if( j > 0){
            dfs(i,j-1,board,p,res);
        }
        
        if( i < board.length - 1){
            dfs(i+1,j,board,p,res);
        }
        
        if( j < board[0].length - 1){
            dfs(i,j+1,board,p,res);
        }

        board[i][j] = c;
    }
    
    private TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();
        
        
        for( String word: words){
         TrieNode p = root;
         for( char c : word.toCharArray()){
             int i = c - 'a';
             if(p.children[i] == null){
                 p.children[i] = new TrieNode();
             }
             
             p = p.children[i];
         }
            p.word = word;
        }
        
        return root;
    }
}