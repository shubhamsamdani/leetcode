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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        
        return pathSum(root,0,targetSum);
    }
    
    boolean pathSum(TreeNode node, int curr, int sum){
        if(node == null){
            return false;
        }
        
        if(curr + node.val == sum  && (node.left == null && node.right == null))
            return true;
            
        return pathSum(node.left,curr+node.val,sum) || pathSum(node.right,curr+node.val,sum);
    }
}