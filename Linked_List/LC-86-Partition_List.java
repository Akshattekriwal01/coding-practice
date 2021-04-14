 // TIME O(n) -> visited every element twice.
 // Space O(n) -> used auxillary stacks + new Linked List returned
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
    public ListNode partition(ListNode head, int x) {
        Stack<Integer> notsmaller = new Stack<Integer>();
         Stack<Integer> smaller = new Stack<Integer>();
        ListNode temp = head ;
        
        while(temp != null){
        if(temp.val < x){
            smaller.push(temp.val);
        }else{
            notsmaller.push(temp.val);
        }
         temp =temp.next;
        }
        if(notsmaller.empty() || smaller.empty()){
            //means target is not in range of given list. 
            return head;
        }
         ListNode ahead = null ;
        while(!notsmaller.empty()){
           ListNode b =  new ListNode(notsmaller.pop(),ahead);
                ahead = b;
        }
        while(!smaller.empty()){
             ListNode a =  new ListNode(smaller.pop(),ahead);
            ahead = a;
        }
       return ahead; 
    }
}
