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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode t1 = l1 ; 
            ListNode t2 = l2 ; 
            ListNode dummy = new ListNode() ;
            ListNode ans = dummy ;
            int carry = 0 ;
            while(t1 != null && t2 != null){
                int sum = carry + t1.val + t2.val ; 
                if(sum >= 10){
                 carry = 1;   
                }else {
                    carry = 0 ;
                }
                ans.next = new ListNode(sum%10) ;
                ans = ans.next ;
                t1 = t1.next ;
                t2 = t2.next ;
            }
        
            while(t1 == null && t2 != null){
                int sum = carry + t2.val ; 
                if(sum >= 10){
                 carry = 1;   
                }else {
                    carry = 0 ;
                }
                ans.next = new ListNode(sum%10) ;
                ans = ans.next ;  
                t2 = t2.next ;
            }
            while(t1 != null && t2 == null){
                int sum = carry + t1.val ; 
                if(sum >= 10){
                 carry = 1;   
                }else {
                    carry = 0 ;
                }
                ans.next = new ListNode(sum%10) ;
                ans = ans.next ;  
                t1 = t1.next ;
            }
        
            if(carry > 0 ){
                ans.next = new ListNode(carry);
            }
        return dummy.next ;
    }
}