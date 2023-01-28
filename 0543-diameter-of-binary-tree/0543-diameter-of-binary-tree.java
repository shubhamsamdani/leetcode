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
    private int diameter;
    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        getDepth(root);
        return diameter;
    }
    
    private int getDepth(TreeNode node){
        if(node == null){
            return 0;
        }
        
        
        int ldepth = getDepth(node.left);
        int rdepth = getDepth(node.right);
        
        diameter = Math.max(diameter, ldepth+rdepth);
        return Math.max(ldepth,rdepth) + 1;
    }
}