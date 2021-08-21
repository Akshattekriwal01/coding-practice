class Solution {
    // finding connnected component without making a graph. 
    int[] parent ;
    int[] size ;
    public int numSimilarGroups(String[] strs) {
        parent = new int[strs.length] ; 
        size = new int[strs.length] ;
        for(int i = 0 ; i < parent.length ; i++){
            parent[i] = i ;
            size[i] = 1 ;
        }
        int numberOfSet = strs.length ;
        
        for(int i = 0 ; i < strs.length ; i ++){
            for(int j = 0 ; j < strs.length ; j ++){
                if(isSimilar(strs[i],strs[j])){
                    int p1 = findParent(i) ;
                    int p2 = findParent(j) ;
                    if(p1 != p2){
                        merge(p1,p2);
                        numberOfSet -- ;
                    } 
                }
                
            }
        }
        return numberOfSet;
        
        
    }
    
    int findParent(int v){
        if(parent[v] == v) return v ; 
        else{
            // path compression
            parent[v] = findParent(parent[v]) ;
            return parent[v] ; 
        }
    }
    
    void merge(int p1, int p2){
        if(size[p1] < size[p2]){
            parent[p1] = p2 ;
            size[p2] += size[p1];
        }else{
             parent[p2] = p1 ;
            size[p1] += size[p2];
        }
    }
    
    boolean isSimilar(String s1, String s2){
        int mistakes = 0 ;
        int i = 0 ; 
        while(i < s1.length() ){
            if(s1.charAt(i) != s2.charAt(i)){
               if( ++mistakes > 2 ){
                   return false ;
               } 
            }
            i++ ;
        }
        return true ; 
    }
}