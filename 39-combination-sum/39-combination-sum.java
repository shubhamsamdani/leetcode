class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> res = new ArrayList<>();
        helper(candidates, target, new ArrayList<>(), res, 0, 0);
        return res;
    }
    
    void helper(int[] candidates, int target, List<Integer> curr, List<List<Integer>> res, int currSum, int index){
        if(currSum == target){
            res.add(new ArrayList<>(curr));
        }
        
        if(currSum > target || index >= candidates.length){
            return;
        }
        
        for(int i = index; i < candidates.length; i++){
            curr.add(candidates[i]);
            helper(candidates, target, curr, res, currSum + candidates[i], i);
            curr.remove(curr.size() - 1);
        }
    }
}