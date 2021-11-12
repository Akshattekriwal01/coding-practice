/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 
 d[7,7,7,7]
 t 
 7 
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy =new ListNode(-1);
        dummy.next = head ;
        ListNode temp = dummy; 
        
        while(temp.next != null){
            if(temp.next.val == val){
                temp.next = temp.next.next ; 
            }else if(temp.next != null) temp = temp.next ;
        }
             
        return dummy.next ;
    }
}