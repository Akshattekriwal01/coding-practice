/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
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
    public TreeNode sortedListToBST(ListNode head) {
        return helper(head, null);
    }
    public TreeNode helper(ListNode start, ListNode end ){
        if(start == end){
            // return new TreeNode(start.val);
            return null ;
        }
        
        ListNode mid = middile(start,end);
        TreeNode node =  new TreeNode(mid.val) ;
        node.left = helper(start,mid);
        node.right = helper(mid.next,end);
        return node;
    }
    
    public ListNode middile(ListNode head, ListNode end){
        if(head == null ){
            return head ;
        }
        ListNode fast = head ; 
        ListNode slow = head ; 
        while(fast.next != end && fast.next.next != end){
            fast = fast.next.next ; 
            slow = slow.next ;
        }
        return slow;
    }
}