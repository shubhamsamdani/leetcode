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
    public TreeNode increasingBST(TreeNode root) {
        Stack<TreeNode> s1 = new Stack<>();
        TreeNode curr = root;
        TreeNode newRoot = null;
        TreeNode prev = null;
        
        while(!s1.isEmpty() || curr != null){
            while(curr != null){
                s1.push(curr);
                curr = curr.left;
            }
            
            TreeNode top = s1.pop();
            top.left = null;
            if(newRoot == null){
                newRoot = top;
            }

            if(prev !=null){
                prev.right = top;
            }

            prev = top;
            curr = top.right;
        }
        
        return newRoot;
    }
}