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

class Pair{
    TreeNode n ; 
    int i ; 
    Pair( TreeNode n, int i){
        this.n = n; 
        this.i = i ;
    }
}
class Solution {

    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 1 ;
     
        Queue<Pair> q = new LinkedList<Pair>() ;
        
        q.add(new Pair(root, 0)); 
        int width = 0 ;
        while(!q.isEmpty()){
            int len = q.size(); 
            int lm = Integer.MAX_VALUE; 
            int rm = Integer.MIN_VALUE;
            for(int i = 0 ; i < len ; i++){
                Pair p = q.poll() ; 
                lm = Math.min(lm, p.i);
                rm = Math.max(p.i, rm ) ;
                if(p.n.left != null){
                    q.add(new Pair(p.n.left, p.i *2 + 1));
                }
                if(p.n.right != null){
                    q.add(new Pair(p.n.right, p.i*2 + 2));
                }
            }
            width = Math.max(width, rm - lm + 1 ) ;
        }
        return width ;
    }
}