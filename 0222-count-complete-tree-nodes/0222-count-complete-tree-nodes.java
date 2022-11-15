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
    public int countNodes(TreeNode root) {
        int count = 0;
        if(root == null){
            return count;
        }
        
        Queue<TreeNode> q1 = new LinkedList<>();
        q1.offer(root);
        
        while(!q1.isEmpty()){
            int size = q1.size();
            count += size;
            for(int i = 0; i < size; i++){
                TreeNode temp = q1.poll();
                if(temp.left != null){
                    q1.offer(temp.left);
                }
                
                if(temp.right != null){
                    q1.offer(temp.right);
                }
            }
        }
        
        return count;
    }
}