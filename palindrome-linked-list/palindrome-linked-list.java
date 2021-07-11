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
    public boolean isPalindrome(ListNode head) {
       /*
        -find the middle of the list.
        1->2->1 
           ^
        1->2->2->1  // ROUND down middile, helpful for breaking the list. 
           ^
        -break the list apart and reverse 2nd list 
         1->2->n 
         1->n
         
         1->2->n
         1->2->n
        -When either one or both pointers are null that means the list is palindrome.
        -fix the change made in data;
        
        */
            
        ListNode mid = middile(head); 
        ListNode rev = reverse(mid.next);
        mid.next = null;
        
        ListNode left = head;
        ListNode right = rev;
        boolean flag = true;

        while(left!= null && right!=null ){
            if(left.val != right.val){
                flag = false;
                break;
            }
            left = left.next;
            right = right.next;
        }
        
        rev = reverse(rev);
        mid.next = rev;
        return flag;
    }
    
    
    public ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode prev = null; 
        ListNode curr = head ; 
        while(curr != null){  // if you put curr.next!=null then curr will stop at tail and n-1 nodes will be returned
            ListNode forward = curr.next ; // backup of future nodes;
            curr.next = prev; 
            prev = curr; 
            curr= forward;
        }
        return prev;
    }
    
    public ListNode middile(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode slow = head ; 
        ListNode fast = head ; 
        
       while(fast.next != null && fast.next.next != null){
            fast = fast.next.next ; 
            slow = slow.next ; 
        }
        return slow; 
        
    }
    
    
}