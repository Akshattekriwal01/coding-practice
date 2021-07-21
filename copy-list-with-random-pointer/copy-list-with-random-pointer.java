/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
/*
first simply copy the linked list 
for every node a in the orignal list map a* from another list.
*/
class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node,Node> map = new HashMap<Node,Node>(); 
        
        Node curr = head ;
       
        Node head2  = new Node(-1) ;
         Node copy = head2  ;
        while(curr != null){
            copy.next = new Node(curr.val);
            copy = copy.next ;
            map.put(curr,copy);
            curr = curr.next ;
           
        }
        head2 = head2.next ;
        curr = head ;
        copy = head2 ;
        while(copy != null){
            copy.random = map.get(curr.random);
            copy = copy.next ;
            curr = curr.next ;
        }
        return head2 ;
    }
}