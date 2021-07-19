// first write the doubly linked list implementation and then write the linkedhashmap representation.

class ListNode {
    int key, val ; 
    ListNode prev , next ;
    ListNode (int key,int value){
        this.key = key ; 
        this.val = value ; 
    }
}
class LRUCache {
    int capacity ; 
    ListNode head = null ; 
    ListNode tail = null ;
    private HashMap<Integer, ListNode> map ; 
    public LRUCache(int capacity) {
     this.capacity = capacity ; 
      map = new HashMap<>();
    }
    
    public void addLast(ListNode n){
        if(map.size() == 0 ){
            tail = n ; 
            head = n ;
        }else{
             tail.next = n ; 
             n.prev = tail;
             tail = tail.next ; 
        }
        
    }
    
    public void remove(ListNode node){
        if(map.size() == 1){
            head = null ;
            tail = null ;
        }else if(node.prev == null){ // removing the head ;
            head = head.next ;
            head.prev = null ;
            node.next = null ;
        }else if(node.next == null){ // removing the last element ;
            tail = tail.prev;
            tail.next = null ;
            node.prev = null ;
        }else{ // removing something in the middile.
            ListNode next = node.next ;
            ListNode prv =  node.prev ; 
            prv.next = next ;
            next.prev = prv ;
            node.next = null ;
            node.prev = null ;
            // nullize next and prev at the end;
        }
        map.remove(node.key);
    }
    public void makeRecent(ListNode node){
        int key = node.key;
        remove(node);
        addLast(node);
        map.put(key,node);
    }
    
    public int get(int key) {
        if(map.containsKey(key)){ // in java we should use containsKey !!!!!!!!
            ListNode node = map.get(key);
            makeRecent(node);
            int ans = node.val;
              return ans;
        }else{
            return -1 ;
        }
      
    }
    
    public void put(int key, int val) {
        if(get(key) != -1 ){ // get will put the node at the tail ;
          ListNode node =  map.get(key);
          node.val = val ;
        }else{
            if(map.size() >= capacity){
                remove(head);    
            }
                ListNode n = new ListNode(key,val);
                addLast(n);
                map.put(key,n);
        }
      //  display(head);
    }
    public void display(ListNode head){
        ListNode curr = head ;
        while(curr != null){
            System.out.print("["+curr.key+","+curr.val+",]");
            curr = curr.next ;
        }
        System.out.println();
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

