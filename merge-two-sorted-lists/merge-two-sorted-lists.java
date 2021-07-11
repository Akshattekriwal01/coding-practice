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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        
        ListNode prev = dummy; 
        ListNode curr1 = l1; 
        ListNode curr2 = l2;
        
        while(curr1 != null && curr2 != null){ // means keep working unless c1 or c1 is null
            if(curr1.val <= curr2.val){
                prev.next = curr1 ;
                curr1 = curr1.next ;
                prev = prev.next ; 
            }else{
                prev.next = curr2 ;
                curr2 = curr2.next ;
                prev = prev.next ; 
            }
        }
        
        //direct the remaining list to the remaingin node
        prev.next = curr1 == null ? curr2 : curr1;
        
        return dummy.next;
    }
}