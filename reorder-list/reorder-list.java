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
    public void reorderList(ListNode head) {
    
        ListNode p1 = head ;
        // code for breaking list
        ListNode mid = middile(head);
        ListNode rev = reverse(mid.next);
        mid.next = null; 
        
             
        ListNode c1 = rev;
         ListNode p2 =head ; 
        while(p2!=null){
           p2 = p1.next;
            p1.next = c1 ;
            p1 = c1 ;
            c1 = p2 ; 
            
        }
                 
    }
    
    //returns rouded down mid, as used for breaking the list
    public ListNode middile(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode slow = head ; 
        ListNode fast = head ; 
        //round down when even
        while(fast.next != null && fast.next.next != null ){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        return slow;

        
    }
    
    public ListNode reverse(ListNode head ){
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode prev = null ; 
        ListNode curr = head ; 
        
        while(curr != null){
            ListNode forward = curr.next ; // next should be backedup
            curr.next = prev; 
            prev = curr; 
            curr = forward;
        }
        
        return prev; //prev becomes the new head;
    }
}