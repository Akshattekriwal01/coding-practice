class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n = grid1.length ; 
        int m = grid1[0].length ; 
         int count = 0 ;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid2[i][j] == 1){
                    if(dfs(i,j,grid1,grid2)){
                        count++ ;
                    } 
                }
            } 
        }
        return count ;
    }
    
    public boolean dfs(int i , int j, int[][] grid1, int[][] grid2){
        int n = grid1.length ; 
        int m = grid1[0].length ; 
        
        boolean flag =  grid1[i][j] == 1 ;
        grid2[i][j] = -1 ; 
        int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
        boolean ans  =  true; 
        for(int d = 0 ; d < 4 ; d++){
            int r = i + dir[d][0];
            int c = j + dir[d][1];
            
            if(r >= 0 && c >=0 && r < n && c < m && grid2[r][c] == 1 ){
              ans = ans & dfs(r,c,grid1,grid2);
            }
        }
        
        return flag && ans ;
        
    }
}