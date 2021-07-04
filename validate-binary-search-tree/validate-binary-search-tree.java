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
    public boolean isValidBST(TreeNode root) {
        return morrisInOrder(root);
    }
    public boolean morrisInOrder(TreeNode root){
        long prev = Long.MIN_VALUE;
        TreeNode curr = root ;
        while(curr != null){
            TreeNode left = curr.left ; 
            if(left == null){
                System.out.println(curr.val);
                 if(prev >= curr.val) return false;  
                prev = curr.val; 
                  curr = curr.right ;
          
            }else{ // create thread 
                TreeNode rightMost = rightMost(left, curr);
                if(rightMost.right == null){
                    rightMost.right = curr; // Thread is created. 
                        curr = curr.left ;
                }else{ // delete thread ; 
                    rightMost.right = null ;
                   if(prev >= curr.val) return false;  
                    prev = curr.val;
                    curr = curr.right ;  
                }
                
                
            }
        }
        return true;
    }
    public TreeNode rightMost(TreeNode left , TreeNode root){
        while(left.right != null && left.right != root){
            left = left.right;
        }
        return left; 
    }
}