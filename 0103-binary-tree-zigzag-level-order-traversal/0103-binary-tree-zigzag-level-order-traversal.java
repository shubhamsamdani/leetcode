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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
         List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        
        boolean queue = true;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            Stack<TreeNode> tempS = new Stack<>();
            Queue<TreeNode> tempQ = new LinkedList<>();
            for(int i = 0; i < size; i++){
                TreeNode temp = q.poll();
                if(temp.left != null){
                    q.offer(temp.left);
                }
                
                if(temp.right != null){
                    q.offer(temp.right);
                }
                
                if(queue){
                    tempQ.offer(temp);
                } else{
                    tempS.push(temp);
                }
            }
            
            List<Integer> res1 = new ArrayList<>();
            if(queue){
                while(!tempQ.isEmpty()){
                    res1.add(tempQ.poll().val);
                }
                
                queue = false;
            } else{
                while(!tempS.isEmpty()){
                    res1.add(tempS.pop().val);
                }
                
                queue = true;
            }
            
            res.add(res1);
        }
        
        return res;
    }
}