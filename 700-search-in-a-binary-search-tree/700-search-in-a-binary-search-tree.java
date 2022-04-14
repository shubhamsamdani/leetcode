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
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null || root.val == val){
            return root;
        }
        
        Queue<TreeNode> q = new LinkedList<TreeNode>(); 
        if(root.val > val){
            TreeNode t = root.left;
            q.add(t);     
        }else{
             q.add(root.right);
        }
       
        while(!q.isEmpty()){
            TreeNode temp = q.poll();
            if(temp == null || temp.val == val){
                return temp;
            } else if( temp.val > val){
                q.add(temp.left);
            } else {
                q.add(temp.right);
            }
        }
        
        return null;
    }
}