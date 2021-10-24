class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[][] ins = new int[trips.length ][2] ;
        int[][] outs = new int[trips.length ][2] ;
        
        for(int i = 0 ; i < trips.length ; i++) {
            ins[i][0] = trips[i][1] ;
            outs[i][0] = trips[i][2] ;
            ins[i][1] = trips[i][0] ; 
            outs[i][1] = trips[i][0];
        }
        Arrays.sort(ins , (a,b)->{ return a[0] - b[0]; }) ;
        Arrays.sort(outs , (a,b)->{ return a[0] - b[0] ;}) ;
        int i = 0 ; 
        int j = 0 ; 
        int total = 0 ; 
        int max = 0 ;
        while(i < trips.length && j < trips.length ){
         if(ins[i][0] < outs[j][0]){
          total += ins[i][1] ;   
             i++;
         }else{
           total -= outs[j][1] ;
           j++;
         }
          if( total > capacity) return false ;
        }
        return true ;
    }
}

/**

-------
 2 ----------
     1
    ------
      3
 
*/