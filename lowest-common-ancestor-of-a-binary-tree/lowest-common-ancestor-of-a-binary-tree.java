/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


// solving this question in O(1) space keeping in mind that the both the node may not be present and one node me be the lca of another. 
class Solution {
    TreeNode ancestor ;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            lca(root,p,q);
            return ancestor;
        }
    
    public boolean lca(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return false;
    
       else {

            boolean flag = (root == q || root == p); 
            boolean left = lca(root.left, p,q);
            if(flag && left) { // case when in is child of another
                ancestor = root;
                return true;
            }
            boolean right = lca(root.right, p, q);
            if(flag && right ){ // case when in is child of another
                ancestor = root; 
                return true;
            }
            if(left && right){ // case when p and q are child of this node;
                ancestor = root;
                return true;
            }
            if(flag || left || right){ // case when root matches or the left child is true or the right child is true
                return true;
            }
            return false;
        }
    }
}

