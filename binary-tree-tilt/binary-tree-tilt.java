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
    int total = 0 ;
    public int findTilt(TreeNode root){
        sum(root);
        return total ;
    }
    public int sum(TreeNode root) {
        if(root == null) return 0 ; 
        
        int sumLeft = 0 ; 
        int sumRight = 0 ;
        if(root.left != null)
            sumLeft = sum(root.left); 
        if(root.right != null)
            sumRight = sum(root.right); 
        
        total += Math.abs(sumLeft - sumRight) ; 
        
        return sumLeft + sumRight + root.val ;
    
    }

}