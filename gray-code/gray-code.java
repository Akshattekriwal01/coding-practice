class Solution {
    private class Pair{
        List<Integer> al ; 
        int bitLength ; 
        public Pair(  List<Integer> al , int bitLength ){
            this.al  = al ;
            this.bitLength = bitLength ; 
        }
    }
    public List<Integer> grayCode(int n) {
        
        Pair p = helper( n);
        return p.al ; 
    }
    
    public Pair helper(int n  ){
        if(n == 1){
            List<Integer> al = new ArrayList<Integer>();
            al.add(0);
            al.add(1);
            Pair p = new Pair(al,1);
            return p ;
        }else{
           Pair p =  helper(n-1);
            int len = p.al.size();
            
            for(int i = len -1; i > -1 ; i--){
                p.al.add(  ((int) p.al.get(i)) ^ (1 << p.bitLength) );
                
            }
            p.bitLength ++ ;
            for(int j : p.al){
            System.out.println(Integer.toBinaryString(j));
            }
            
            return p;
        }
    }
    
}

/**



*/