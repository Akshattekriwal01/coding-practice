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
class BSTIterator {
    LinkedList<TreeNode> stack ; 
    public BSTIterator(TreeNode root) {
        stack = new LinkedList<>();
        insertAllLeft(root);
    }
    
    public int next() {
        if(!stack.isEmpty()){
            TreeNode n = stack.pop();
            insertAllLeft(n.right);
            return n.val;
        }
        return -1;
    }
    
    public boolean hasNext() {
        return stack.size() > 0 ;
    }
    
    public void insertAllLeft(TreeNode node){
        while(node != null){
            stack.push(node);
            node = node.left ; 
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */