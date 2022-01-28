class WordDictionary {

    class Trie{
        Trie[] children;
        boolean isLeaf;
        public Trie(){
            children = new Trie[26];
        }
    }
    
    private Trie root;
    public WordDictionary() {
        root = new Trie();
    }
    
    public void addWord(String word) {
        Trie curr = root;
        for(char c : word.toCharArray()){
            int idx = c - 'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new Trie();
            }
            
            curr = curr.children[idx];
        }
        curr.isLeaf = true;
    }
    
    private boolean search_helper(String word, int len, Trie root){
        if(word.length() == len){
            return root.isLeaf;
        }
        
        char c = word.charAt(len);
        
            if( c == '.'){
                for(int i = 0; i < 26; i++){
                    if(root.children[i] != null && search_helper(word, len+1, root.children[i])){
                        return true;
                    }
                } 
            } else{
                    int i = c - 'a';
                    if(root.children[i] != null && search_helper(word, len+1, root.children[i])){
                        return true;
                    } 
            }
        
        
        return false;
    }
    
    public boolean search(String word) {
        return search_helper(word, 0, root);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */