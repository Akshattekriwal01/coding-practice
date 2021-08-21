// basically return the edge of a cycle, or make minimum spanning tree and return the edge of a cycles.


class Solution {
    int[] parent , size ;
    public int[] findRedundantConnection(int[][] edges) {
      int n = edges.length ; 
       parent = new int[n+1];
       size = new int[n+1];
        int[] ans = new int[2] ;
        for(int i = 0 ; i < n ; i++){
            parent[i] = i ;
            size[i] = 1 ;
        }
        
        
        for(int[] edge : edges){
         int v1 =  findParent(edge[0]);
         int v2 = findParent(edge[1]);
            
            // we know that v1 and v2 have edges between them. if v1 == v2 , means there is a cycle
            
            if(v1 == v2){
                ans[0] = edge[0];
                ans[1] = edge[1] ;
                return ans ;
            }else{
                merge(v1,v2);
            }
        }
        return ans ;
     
    }
    
    public int findParent(int v){
        if(parent[v] == v) return v ;
        else{
          return findParent(parent[v]);
        }
    }
    
    public void merge(int president1 , int president2){
        if(size[president1] < size[president2]){
            parent[president1] = president2 ;
            size[president2] += size[president1];
        }else{
            parent[president2] = president1 ;
            size[president1] += size[president2]; 
        }
    }
    
}
