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
    public boolean isBalanced(TreeNode root) {
        return helper(root).isBalanced;
    }
    public Pair helper(TreeNode root){
            if(root == null){
                return new Pair(); 
            }else{
                Pair left = helper(root.left);
                Pair right = helper(root.right);
                
                Pair p = new Pair();
                p.height = 1 + Math.max(left.height, right.height);
               
                if(left.isBalanced && right.isBalanced && Math.abs(left.height - right.height) < 2){
                    p.isBalanced = true ; 
                }else{
                    p.isBalanced = false ;
                }
                return p ;
                
            }
    }
}

class Pair {
    boolean isBalanced = true ;
    int height = -1 ; 
    
}