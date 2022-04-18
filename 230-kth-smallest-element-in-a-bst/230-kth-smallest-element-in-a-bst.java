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
    Queue<TreeNode> s = new LinkedList<>();
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root);
        
        int i = 0;
        while(i < k && !s.isEmpty()){
            TreeNode temp = s.poll();
            if(i == k-1){
                return temp.val;
            }
            i++ ;
        }
        
        return -1;
    }
    
    
    void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        
        inOrder(root.left);
        s.add(root);
        inOrder(root.right);
    }
}