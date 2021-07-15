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
/*
in [10,9,3,15,20,7], post [10,9,15,7,20,3]

root = post[len -1 ]; 
find root in inorder 
idx = 1
ttl = idx - inStart ; 

postLeft: postStart,postStart+ttl -1  inLeft -  inStart, idx-1 
postRigh: postStart+ttl,postEnd  inRight -  idx+1 , inEnd;

*/

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length ;
        return build(inorder, postorder, 0 ,n-1,0,n-1);
    }
    public TreeNode build(int[] inorder, int[] postorder, int postStart, int postEnd, int inStart, int inEnd){
        if(postStart > postEnd){ // can also check inStart and inEnd, same thing
            return null;
        }
        int idx = inStart ; 
        while(postorder[postEnd] != inorder[idx] ){
            idx++ ;
        }
        int ttl = idx - inStart ; 
        
        TreeNode root = new TreeNode(postorder[postEnd]);
        
        root.left =  build(inorder, postorder, postStart, postStart + ttl -1 , inStart, idx -1 );
        root.right = build(inorder, postorder, postStart + ttl , postEnd - 1, idx+1, inEnd);
        return root ; 
        
    }
}