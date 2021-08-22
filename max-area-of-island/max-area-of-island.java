// to find connected componenent using dsu , count 1's and subtract on every merge, remaining number will be the gcc ;
class Solution {
    int[] parent , size ; 
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length , n = grid[0].length ;
        if( m == 0  || n == 0 ) return 0;  
        int maxSize = 0 ; 
        parent = new int[m*n];
        size = new int[m*n];
        for(int i = 0 ; i < m*n ; i++){
            parent[i] = i ;
            size[i] = 1;
        }
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 1){
                    int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
                    int p1 = findParent(i * n + j); 
                    
                    for(int[] d : dir){
                        int r = i + d[0] ; 
                        int c = j + d[1] ;
                        
                        if(r >= 0 && c >= 0 && r < m && c < n && grid[r][c] == 1 ){
                            int p2 = findParent(r * n + c) ; 
                            if(p1 != p2 ){
                                parent[p2] = p1 ;     // dont make parent of p1 as p2 ;
                                size[p1] += size[p2];
                            }
                        }
                    }
                    maxSize = Math.max(maxSize, size[p1]);
                }       
            }
        }
        return maxSize ;
    }
    public int findParent(int v){
        if(parent[v] == v){
            return v ; 
        }else{
            parent[v] = findParent(parent[v]); 
            return parent[v];
        }
    }
}