/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(original == null){
            return null;
        }
        
        Queue<TreeNode> q1 = new LinkedList<>();
        q1.offer(original);
        
        Queue<TreeNode> q2 = new LinkedList<>();
        q2.offer(cloned);
        
        while(!q1.isEmpty()){
            int size = q1.size();
            while(size-- > 0){
                TreeNode temp1 = q1.poll();
                TreeNode temp2 = q2.poll();
                
                if(temp1 == target){
                    return temp2;
                }
                
                if(temp1.left != null){
                    q1.offer(temp1.left);
                    q2.offer(temp2.left);
                }
                
                if(temp1.right != null){
                    q1.offer(temp1.right);
                    q2.offer(temp2.right);
                }
            }
        }
        
        return null;
    }
}