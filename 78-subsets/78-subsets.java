class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0){
            return res;
        }
        
        res.add(new ArrayList<>());
        helper(nums, res, new ArrayList<>(), 0);
        
        return res;
    }
    
    private void helper(int[] nums, List<List<Integer>> res, List<Integer> curr, int index){
        if(index >= nums.length){
            return;
        } else{
            for(int i = index; i < nums.length; i++){
                curr.add(nums[i]);
                res.add(new ArrayList<>(curr));
                helper(nums,res,curr,i+1);
                curr.remove(curr.size() - 1);
            }
        }
    }
}