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
    public int deepestLeavesSum(TreeNode root) {
        int sum = 0;
        Queue<TreeNode> q1 = new LinkedList<>();
        
        if(root == null){
            return sum;
        }
        
        q1.add(root);
        
        while(!q1.isEmpty()){
            
            int size = q1.size();
            while(size-- > 0){
                TreeNode temp = q1.poll();
                sum += temp.val;
                
                if(temp.left != null){
                    q1.add(temp.left);
                }
                
                if(temp.right != null){
                    q1.add(temp.right);
                }
            }
            
            if(!q1.isEmpty()){
                sum = 0;
            }
        }
        
        return sum;
    }
}