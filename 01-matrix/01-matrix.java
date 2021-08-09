class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int columns = mat[0].length ; 
        int[][] ans = new int[rows][columns]; 
        
        Queue<Integer> q = new LinkedList<Integer>() ; 
        
        // index = i * colums + j ; 
        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j < columns ; j++){
                if( mat[i][j] == 0){
                    q.add( i * columns + j);
                }
            }
        }
        int level = 0 ; 
        while(!q.isEmpty()){
            int size = q.size() ; 
            while(size-- > 0){
               int rem = q.poll() ; 
               int i = rem / columns ;
                int j = rem % columns ;
            int[][] dir = {{0,1},{-1,0},{0,-1},{1,0}};
                ans[i][j]  = level ; 
                for(int d = 0 ; d < 4 ; d ++){
                    int r = i + dir[d][0] ;
                    int c = j + dir[d][1] ; 
                    
                    if( r < rows && c < columns && r >=0 && c >= 0 && mat[r][c] != -1 && mat[r][c] != 0){
                        mat[r][c] = -1 ;
                        q.add(r * columns + c ) ;
                    }
                }
            }
            level++ ;
        }
        return ans ; 
    }
}