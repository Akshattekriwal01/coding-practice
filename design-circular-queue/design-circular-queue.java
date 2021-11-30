class MyCircularQueue {
     int[] arr ;
    int head  ; 
    int tail  ;
    int k ;
    public MyCircularQueue(int k) {
    arr = new int[k] ;
        Arrays.fill(arr,-1);
        head  = 0 ;
        this.k = k ;
        tail =   0 ;
    } 
    public boolean enQueue(int value) {
        if(arr[head] == -1){
            arr[head] = value ;
            head = (head + 1) % k ;
            return true;
        }
        return false;
    }

    public boolean deQueue() {
           
        if(arr[tail] == -1) return false ; 
         arr[tail] = -1 ;
        tail = (tail+1) % k;
        
        return true;
    }
    public int Front() {
        //  int index = tail - 1 ; 
        // if(index < 0 ) index = k - 1;
        return arr[tail];
    }
    
    public int Rear() {
        int index = head - 1 ; 
        if(index < 0 ) index = k - 1;
        return arr[index];
    }
    
    public boolean isEmpty() {
        return (head == tail && arr[head] == -1);
    }
    
    public boolean isFull() {
        return (head == tail && arr[head] != -1);
    }
}
/*
2 3 _
    h
t

*/
/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */