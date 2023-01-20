class Solution {
    private Set<List<Integer>> ans;
    public List<List<Integer>> findSubsequences(int[] nums) {
        ans = new HashSet<>();
        backtrack(0,nums,new ArrayList<>());
        return new ArrayList<>(ans);
    }
    
    private void backtrack(int curr, int[] nums, List<Integer> currList){
        if(currList.size() >= 2){
            ans.add(new ArrayList<>(currList));
        }
        
        for(int i = curr; i < nums.length; i++){
            if(currList.isEmpty() || currList.get(currList.size() - 1) <= nums[i]){
                currList.add(nums[i]);
                backtrack(i+1,nums,currList);
                currList.remove(currList.size() - 1);
            }    
        }
    }
}