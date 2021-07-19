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
/*
1  3  5 9 10 
        c1 
2  4  7
        c2
 dummy - 1 - 2 - 3 - 4 - 5 - 7  
                             p
*/
// merge sort in linkedlist because no need for allocating extra memory. 
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head ;
        }
        // routine for splitting 2 list. 
        ListNode mid = middle(head);
        ListNode nhead = mid.next ; 
        mid.next = null ;
        // the code above this comment devides and the code below this comment conqures.    
        return merge(sortList(head), sortList(nhead));
 
        
       
        
    }
    public ListNode merge(ListNode h1 , ListNode h2 ){
        if(h1 == null || h2 == null){
            return h1 != null ? h1 : h2 ;
        }
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy ; 
        
        ListNode c1 = h1 ; 
        ListNode c2 = h2 ;
        
        while(c1!= null && c2 != null){
            if(c1.val <= c2.val){
                prev.next = c1 ; 
                c1 = c1.next ;
            }else{
               prev.next = c2 ; 
              c2 = c2.next ; 
            }
            prev = prev.next ;
        }
        ListNode head = dummy.next ; 
        dummy.next = null ; 
        if(c1 == null && c2 == null){
           
        }else if(c1 == null){
            prev.next = c2 ;
        }else if(c2 == null){
            prev.next = c1 ; 
        }
        // when you make dummy, remember to delete dummy

        return head ; 
        
    }
    public ListNode middle(ListNode head){
        if(head == null || head.next == null){
            return head ;
        }
        ListNode slow = head ; 
        ListNode fast = head ; 
        // return rounded down middle in case of even length ; 
        
        while(fast.next!= null && fast.next.next != null){
            slow = slow.next ; 
            fast = fast.next.next ; 
        }
        return slow ;
    }
}