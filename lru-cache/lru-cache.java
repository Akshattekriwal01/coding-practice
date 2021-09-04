//  [ 1 , 2 ]  





class LRUCache {
        HashMap<Integer, Node> map ;
        final int MAX ; 
    class Node {
        Node prev ; 
        int key ; 
        Node next ; 
        int val ;
        
        public Node(){
            
        }
        public Node(int key,int value ) {
            this.key = key ; 
            this.val = value ;
        
       
    }
         public String toString() {
            return key + ", " +val;
        }
        

    }
    
    Node head ;
    Node tail ;
      public LRUCache(int capacity) {
      map =new HashMap<>() ;
      MAX = capacity ;
    }
    
     public void addLast(Node n){
         if(tail == null){
             head = n ;
             tail = n ;
             n.prev = null ;
         }else{
           tail.next = n ;
            n.prev = tail ;    
            tail = n ;  
         }
          n.next = null ;   
    }
        
    public void remove(Node n ) {    // evict
        if(n.prev != null && n.next != null){
            Node temp = n.prev ; 
            temp.next = n.next ;// p points to f
            n.next.prev = temp ;// f points to p
            
          }else if(n.prev != null){
                tail = n.prev ; 
                tail.next = null ;
            
          }else if(n.next != null){
                head = head.next ; 
                head.prev = null ;
            
          }else{
            head = null ;
            tail = null ;
          }
            n.prev = null ; 
            n.next = null ;
    }
    

  
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1 ;
           Node val =  map.get(key);
           remove(val);
           addLast(val) ;
       // System.out.println(key + ","+ val.key + "," + val.val) ;
           return val.val ; 
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            remove(map.get(key)) ; 
            map.remove(key);
        } 
        
        //System.out.println("put" + map) ;
        // display(head);
        if(map.size() >= MAX){
            map.remove(head.key) ;
            remove( head );
        
        }
        Node n = new Node(key,value); 
        map.put(key, n) ;
        addLast(n) ;
      
    }
    
    public void display(Node head){
        Node temp = head ; 
        
        while(temp != null){
            System.out.print( ":"+temp) ;
            temp = temp.next ;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */