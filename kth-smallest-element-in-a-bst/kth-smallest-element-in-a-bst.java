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
// approach 1 lets do it with stack ;
class Solution {
    
    private void insertAllLeft(TreeNode node, LinkedList<TreeNode> stack){
        while(node != null){
            stack.addFirst(node);
            node = node.left ;
        }
    }
    // what happens if the root is null or the k> tree.size();
    public int kthSmallest(TreeNode root, int k) {
         LinkedList<TreeNode> stack = new LinkedList<>();
        insertAllLeft(root,stack);
        int count = 1 ; 
        while(!stack.isEmpty()){
            TreeNode n = stack.removeFirst();
            if(count == k){
                return n.val ;
            }
            insertAllLeft(n.right, stack);
            count ++;
        }
        return 0 ; 
    }
}