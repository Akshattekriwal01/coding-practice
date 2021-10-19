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

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node > map = new HashMap<Node, Node>() ; 
        
        Node temp = head ;
        Node head2 = new Node(-1) ;
        Node temp2 = head2; 
        while(temp != null){
            temp2.next = new Node(temp.val) ;
            temp2 = temp2.next ;
            map.put(temp, temp2);
            temp = temp.next ;
        }
        
        head2= head2.next ;
        temp = head ;
        temp2 = head2 ;
        
        while(temp != null){
            temp2.random = map.get(temp.random) ;
            temp = temp.next ;
            temp2 = temp2.next ;
        }
        
        return head2 ;
    }
}