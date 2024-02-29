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
    public boolean isEvenOddTree(TreeNode root) {
        
        boolean ans = true;
        Queue<TreeNode> q1 = new LinkedList<>();
        q1.add(root);
        
        int level = 0;
        while(!q1.isEmpty()){
            int size = q1.size();
            
            int prev = 0;
            for(int i = 0; i < size; i++){
                TreeNode node = q1.poll();
                if(node.left != null){
                    q1.add(node.left);
                }
                
                if(node.right != null){
                    q1.add(node.right);
                }
                
                
                if(i == 0){
                    prev = node.val;
                    if(level%2 == 0){
                        if(node.val%2 == 0){
                            return false;
                        }
                    } else{
                        if(node.val%2 == 1){
                            return false;
                        }
                    }
                } else{
                    if(level%2 == 0){
                        if(node.val%2 == 0 || prev >= node.val){
                            return false;
                        }
                    } else{
                        if(node.val%2 == 1 || prev <= node.val){
                            return false;
                        }
                    }
                    
                    //System.out.println("prev: " + prev + ", val: " + node.val);
                    prev = node.val;
                }
            }
            
            level++ ;
        }
        
        return true;
    }
}