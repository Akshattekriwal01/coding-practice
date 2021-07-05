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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length > 0){
            
            return helper(nums,0,nums.length -1);
        }
        return new TreeNode();
    }
    public TreeNode helper(int[] nums, int start, int end){
        if(start > end){
            return null;
        }
        int mid = start + (end - start)/2 ; 
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, start, mid-1);
        node.right = helper(nums, mid+1, end );
        return node ;
    }
}