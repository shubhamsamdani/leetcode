class Solution {
    class Trie {
        Trie[] children;
        public Trie(){
            this.children = new Trie[2];
        }
    }
    
    void buildTrie(int[] nums){
        for(int num : nums){
            Trie curr = root;
            for(int i = 31; i >= 0; i--){
                int currBit = (num >>> i) & 1;
                if(curr.children[currBit] == null){
                    curr.children[currBit] = new Trie();
                }
                
                curr = curr.children[currBit];
            }
        }
    }
    
    int findMaxXorForCurrent(int num){
            Trie curr = root;
            int sum = 0;
            for(int i = 31; i >= 0; i--){
                int currBit = (num >>> i) & 1;
                int targetBit = currBit == 1 ? 0 : 1;
                
                if(curr.children[targetBit] != null){
                    curr = curr.children[targetBit];
                    sum += (1 << i);
                } else{
                    curr = curr.children[currBit];
                }
            }        
        return sum;
    }
    private Trie root;
    public int findMaximumXOR(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        root = new Trie();
        buildTrie(nums);
        int max = Integer.MIN_VALUE;
        
        for(int num : nums){
            int maxXor = findMaxXorForCurrent(num);
            max = Math.max(maxXor,max);
        }
        
        return max;
    }
}