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
preorder = [3,9,20,15,7], 
 inorder = [9,3,15,20,7]  tree in visited from
 idx = 1 ; 
 total elements before it = 1 - inStart 
 root = pre[0]; 
 pre left  = (prestart + 1 , preStart + ttl )     inLeft =  inStart,idx -1  
 pre right = (prestart+ttl+1,preEnd)              in Right =  idx+1, inEnd 
*/
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length ; 
        return build (preorder, inorder, 0,n-1,0,n-1);
    }
    public TreeNode build(int[] preorder,int[] inorder,int preStart,int preEnd ,int inStart, int inEnd){
        if(preStart > preEnd){
            return null;
        }
        
        int idx = inStart ;
         while(inorder[idx] != preorder[preStart]){
            idx++;
        }
        int ttl =  idx - inStart ; 
        TreeNode root = new TreeNode(preorder[preStart]);
        
        root.left = build(preorder, inorder, preStart+1 , preStart + ttl , inStart , idx -1  );
        root.right = build(preorder , inorder, preStart+ttl +1, preEnd, idx+1,inEnd);
        return root ;
    }
}