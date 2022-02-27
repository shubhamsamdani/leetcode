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
    public int widthOfBinaryTree(TreeNode root) {
        
        if(root == null){
            return 0;
        }
        
        int maxWidth = 0;
        Map<TreeNode,Integer> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        map.put(root,0);
        
        while(!queue.isEmpty()){
            TreeNode leftNode = queue.peek();
            int left = map.get(leftNode);
            int size = queue.size();
            
            while(size-- > 0){
                TreeNode head = queue.poll();
                maxWidth = Math.max(maxWidth, map.get(head) - left + 1);
                if(head.left != null){
                    queue.offer(head.left);
                    map.put(head.left, 2*map.get(head));
                }
                
                if(head.right != null){
                    queue.offer(head.right);
                    map.put(head.right,2*map.get(head) + 1);
                }
            }
        }
        
        return maxWidth;
    }
}