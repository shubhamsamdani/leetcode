/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int maxSum = Integer.MIN_VALUE;
    Map<TreeNode,Integer> map;
    public int maxPathSum(TreeNode root) {
        
        map = new HashMap<>();
        if(root == null){
            return 0;
        }
        
        dfs(root);
        return maxSum;
    }
    
    int dfs(TreeNode node){
        if(node == null){
            return 0;
        }
        
        int left;
        if(map.containsKey(node.left)){
            left = map.get(node.left);
        } else{
            left = Math.max(0,dfs(node.left));
        }
        
        int right;
        if(map.containsKey(node.right)){
            right = map.get(node.right);
        } else{
            right = Math.max(0,dfs(node.right));
        }
        
        int sum = right+left+node.val;
        maxSum = Math.max(sum,maxSum);
        
        return Math.max(left,right) + node.val;
    }
}