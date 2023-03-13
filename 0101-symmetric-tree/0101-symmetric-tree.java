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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        
        Queue<TreeNode> q1 = new LinkedList<>();
        q1.offer(root);
        
        while(!q1.isEmpty()){
            int size = q1.size();
            int[] temp = new int[size];
            
            for(int i = 0; i < size; i++){
                TreeNode node = q1.poll();
                
                if(node == null){
                    temp[i] = -101;
                    continue;
                } else{
                    temp[i] = node.val;
                }
                
                if(node.left != null){
                    q1.offer(node.left);
                } else{
                    q1.offer(null);
                }
                
                if(node.right != null){
                    q1.offer(node.right);
                }else{
                    q1.offer(null);
                }
                
                
            }
            
            if(!isValid(temp,size)){
                return false;
            }
        }
        
        return true;
    }
    
    private boolean isValid(int[] arr, int n){
        for(int i = 0; i <= n/2; i++){
            if(arr[i] != arr[n-1-i]){
                return false;
            }
        }
        
        return true;
    }
}