class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> res = new HashSet<>();
        boolean[] visited = new boolean[candidates.length];
        backtrack(candidates, target, visited, 0, new ArrayList<>(), res, 0);
        //Arrays.sort(candidates);
        
        List<List<Integer>> result = new ArrayList<>();
        for(List<Integer> el : res){
            result.add(el);
        }
        
        return result;
    }
    
    void backtrack(int[] nums, int target, boolean[] visited, int curr, List<Integer> currList, Set<List<Integer>> res, int index){
        if(curr == target){
            List<Integer> temp = new ArrayList<>(currList);
            Collections.sort(temp);
            res.add(temp);
            return;
        }
        
        if(curr > target || index >= nums.length){
            return;
        }
        
        int prev=-1;
        for(int i = index; i < nums.length; i++){
            if(prev != nums[i]){
                //visited[i] = true;
                currList.add(nums[i]);
                backtrack(nums,target,visited,curr + nums[i], currList, res, i+1);
                currList.remove(currList.size() - 1);
                //visited[i] = false;
                prev = nums[i];
            }
        }
    }
}