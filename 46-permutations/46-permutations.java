class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        boolean[] visited = new boolean[n];
        findPermute(nums,visited, new ArrayList<>(), res, n);
        return res;
    }
    
    private void findPermute(int[] nums, boolean[] visited, List<Integer> curr, List<List<Integer>> res, int n){
        if(curr.size() == n){
            res.add(new ArrayList<>(curr));
            return;
        }
        
        for(int i = 0; i < n; i++){
            if(visited[i]){
                continue;
            }
            
            visited[i] = true;
            curr.add(nums[i]);
            findPermute(nums,visited, curr, res, n);
            visited[i] = false;
            curr.remove(curr.size() - 1);
        }
    }
}