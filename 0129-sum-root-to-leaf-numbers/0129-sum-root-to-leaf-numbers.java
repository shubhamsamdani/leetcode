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
    
    long sum = 0;
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }
    
    private int dfs(TreeNode node, int currSum){
        
        if(node == null){
            return 0;
        }
        
        if(node.left == null && node.right == null){
            return currSum*10 + node.val;
        }
        
        currSum = currSum*10 + node.val;
        return dfs(node.left,currSum) + dfs(node.right, currSum);
    }
}