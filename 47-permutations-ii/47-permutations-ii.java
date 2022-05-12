class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        if(n == 0){
            return res;
        }
        
        Set<List<Integer>> sets = new HashSet<>();
        boolean[] visited = new boolean[n];
        helper(nums,sets,new ArrayList<Integer>(),visited);
        
        for(List<Integer> list : sets){
            res.add(list);
        }
        
        return res;
    }
    
    
    private void helper(int[] nums, Set<List<Integer>> sets, List<Integer> curr, boolean visited[]){
        if(curr.size() == nums.length){
            sets.add(new ArrayList<>(curr));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(!visited[i]){
                curr.add(nums[i]);
                visited[i] = true;
                helper(nums,sets,curr,visited);    
                visited[i] = false;
                curr.remove(curr.size() - 1);
            }
        }
    }
}