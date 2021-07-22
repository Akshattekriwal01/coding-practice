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
d[1,2,3,4,5]
d1
*/


class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        ListNode th = null ;
        ListNode tt = null ;
        ListNode nh = null ;
        ListNode nt = null ;
         while(curr != null){
             int len = k ;
            while(curr != null && len > 0){
                len--;
                if(len == k-1){
                  tt = curr ;
                  th = curr ;
                  ListNode temp = curr ;
                  curr = curr.next ;
                  temp.next = null;
              
                }else{
                    ListNode temp = curr ;
                    curr = curr.next ;
                    temp.next = th ; 
                    th = temp ;
                }
               
                 
            } 
            if(len == 0){//there were enough nodes.
                if(nt != null){
                    nt.next = th ;
                    nt = tt ;
                }else{
                     nt = tt ;
                    nh =th ;
                }
       
                    th = null;
                    tt = null ;
            }else{//there were not enough nodes.
              ListNode tem = th ;
              ListNode prev = null ;
              while(tem != null){
                ListNode forward = tem.next ; 
                tem.next = prev ;
                prev = tem ;
                tem = forward ;
              }
                nt.next = prev ;
            }
            
        }
        return nh ;
    }
    public void disp(ListNode n){
        while(n != null){
            System.out.print(n.val);
            n = n.next ;
        }
        System.out.println();
    }
}