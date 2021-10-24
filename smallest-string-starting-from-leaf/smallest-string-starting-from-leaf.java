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
    String start = "";
    
    public String smallestFromLeaf(TreeNode root) {
        if(root != null) ;
         dfs(root , start) ;
        return start ;
    }

    public void dfs(TreeNode root , String sofar){
        if(root == null) return ;
        else if(root.left == null && root.right == null){
            sofar = (char)(root.val + 'a') + sofar;
            if(start.length() == 0) start = sofar ;
            int comp = start.compareTo(sofar);
            if(comp > 0) start = sofar ;
        }else{
           dfs( root.left , (char)(root.val + 'a') + sofar) ; 
           dfs(root.right , (char)(root.val + 'a') + sofar) ; 
        }
    } 
}