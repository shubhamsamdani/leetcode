class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        
        if(k > n || n > 45){
            return ans;
        }
        
        helper(k,n,new ArrayList<>(), ans, 1);
        return ans;
    }
    
    void helper(int k, int n, List<Integer> curr, List<List<Integer>> ans, int start){
        if(curr.size() == k){
            if(n == 0){
                //System.out.println("abs");
                ans.add(new ArrayList<>(curr));
            }
            //System.out.println("abs");
            return;
        }
        
        for(int i = start; i <= 9;i++){
            curr.add(i);
            helper(k,n-i,curr,ans,i+1);
            curr.remove(curr.size()-1);
        }
    }
}