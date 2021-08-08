class Solution {
    public int orangesRotting(int[][] grid) {
        // parallel bfs. 
        
        int rows = grid.length ; 
        int columns = grid[0].length ;
        
        Queue<Integer> q = new LinkedList<Integer>() ; 
        int totalOranges = 0 ;
        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ;j < columns ; j++){
                if(grid[i][j] == 2) q.add( i * columns + j ) ; 
                if(grid[i][j] == 1) totalOranges ++ ;
            }
        }
       
        if(totalOranges == 0){
            return 0 ;
        }
        
        int time = 0 ;
        while(!q.isEmpty()){
            int size = q.size() ; 
            while(size-- > 0){
                int rem = q.poll() ; 
                int r = rem / columns ; 
                int c = rem % columns ; 

                int[][] dir = {{0,1}, {-1,0}, {0,-1},{1,0}};
                for(int d = 0 ; d < 4 ; d++){
                    int newr = r + dir[d][0] ; 
                    int newc = c + dir[d][1] ;
                    if(newr < rows && newc < columns && newr >= 0 && newc >= 0 && grid[newr][newc] == 1){
                        q.add(newr * columns + newc);
                         totalOranges-- ; 
                        grid[newr][newc] = 2 ;
                        if(totalOranges == 0 ) return time + 1 ;
                        
                       
                    }
                }
            }
            time++;
        }
        // there are no rooten oranges.
        return -1 ;
    }
}