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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        
        Queue<TreeNode> q1 = new LinkedList<>();
        q1.add(root);
        while(!q1.isEmpty()){
            int size = q1.size();
            List<Integer> list = new ArrayList<>();
            while(size-- > 0){
                TreeNode temp = q1.poll();
                list.add(temp.val);
                
                if(temp.left != null){
                    q1.add(temp.left);
                }
                
                if(temp.right != null){
                    q1.add(temp.right);
                }
            }
            
            res.add(list);
        }
        
        return res;
    }
}