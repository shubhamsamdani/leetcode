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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val);
        }
        
        TreeNode curr = root;
        TreeNode prev = null;
        boolean search = true;
        while(curr != null){
            prev = curr;
            if(curr.val > val){
                curr = curr.left;
            } else{
                curr = curr.right;
            }
        }
        
        if(prev != null){
            TreeNode temp = new TreeNode(val);
            if(prev.val > val){
                prev.left = temp;
            } else{
                prev.right = temp;
            }
        }
        
        return root;
    }
}