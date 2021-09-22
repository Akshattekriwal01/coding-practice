class Solution {
    public int[][] kClosest(int[][] points, int k) {
       PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) -> {
           double d1 = distance(a[0],a[1]) ;
           double d2 = distance(b[0],b[1]);

           int ans = 1 ;
             if (d1 < d2) ans = -1;
             else if (d1 > d2) ans = 1;
             else ans = 0 ; 
             return -1 * ans ;
       }) ;
        
        for(int[] point : points){
        if(pq.size() < k)
           pq.add ( point );   
        else{
            pq.add ( point );  
             System.out.println("here");
            pq.poll() ;
         }
        }
        
        Iterator<int[]> iter = pq.iterator() ;
        int[][] ans = new int[pq.size()][2];
         System.out.println(pq.size());
        int i = 0 ;
        while(iter.hasNext()){
            int[] temp = iter.next() ;
            ans[i][0] = temp[0];
             ans[i][1] = temp[1];
            ++i;
            System.out.println(temp[0]+","+temp[1]);
        }    
        return ans ;   
        
    }
    
    public double distance(int x1, int y1){
        return Math.sqrt(   Math.pow(x1,2) + Math.pow(y1,2) );
    }
}