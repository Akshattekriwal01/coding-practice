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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        helper(root,targetSum, new ArrayList<Integer>(), ans );
        return ans;
        
    }
      public void helper(TreeNode root, int targetSum, List<Integer> sofar, List<List<Integer>> ans  ){
          if(root == null) return ;
          if(root.left == null && root.right == null && targetSum - root.val == 0 ){ // this is correct the only problem is that the "sofar" will be added to the answer twice because of 2 null children.
              sofar.add(root.val);
              ans.add(new ArrayList<Integer>(sofar));
              sofar.remove(sofar.size() - 1);
              return ;
          }else{
            sofar.add(root.val);
             helper(root.left, targetSum - root.val ,  sofar , ans);
             helper(root.right, targetSum - root.val ,  sofar , ans);
            sofar.remove(sofar.size() - 1);
             return ;
          }
      }
}