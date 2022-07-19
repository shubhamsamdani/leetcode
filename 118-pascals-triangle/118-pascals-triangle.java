class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        curr.add(1);
        res.add(curr);
        
        List<Integer> prev = curr;
        
        
        for(int i = 1; i < numRows; i++){
            List<Integer> temp = res.get(i-1);
            curr = new ArrayList<>();
            curr.add(1);
            
            for(int j = 1; j < i; j++){
                curr.add(temp.get(j) + temp.get(j-1));
            }
            
            curr.add(1);
            res.add(curr);
        }
        
        return res;
    }
}