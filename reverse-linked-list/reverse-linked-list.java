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
class Solution {
    public ListNode reverseList(ListNode head) {
        // understand that prev will become the new list. 
        if(head == null || head.next == null){
           return head;
       } 
        
        ListNode prev = null ; 
        ListNode curr = head ; 
       
        while(curr != null ){
            ListNode forward = curr.next ; 
            curr.next = prev ;
            prev = curr ;
            curr = forward ;
                                   
        }
        return prev;
    }
}