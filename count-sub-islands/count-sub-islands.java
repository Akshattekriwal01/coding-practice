class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m  = grid1.length ; 
        int n = grid1[0].length;
        int count = 0 ;
        for(int i = 0 ; i < m; i++ ){
            for (int j = 0 ; j < n ; j++){
               if(grid2[i][j] == 1)
               count =  dfs(i,j,grid1,grid2 ) ? count + 1 : count ;
            }
        }
        return count ;
    }
    
    public boolean dfs(int i , int j ,int[][] grid1, int[][] grid2 ){
        //visited 
        grid2[i][j] = -1 ; 
        int m  = grid1.length ; 
        int n = grid1[0].length;
        boolean land = true ; 
        if(grid1[i][j] == 0)
            land = false ; 
        
        int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
        for(int d = 0 ; d < 4 ; d++){
            int row = i + dir[d][0]; 
            int col = j + dir[d][1];
            
         if(row >= 0 && col >=0 && row < m && col < n && grid2[row][col] == 1 ){
             land = land & dfs(row,col, grid1, grid2);
         }  
        }
        return land ;  
    }
}