class Solution {
    public int numEnclaves(int[][] grid) {
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(i == 0 || i == grid.length -1 || j == 0 || j == grid[0].length - 1  ){
                    if(grid[i][j] == 1){
                        dfs(i,j,grid);
                    }
                }
            }
        }     
        int count = 0 ; 
           for(int i = 0 ; i < grid.length ; i ++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] == 1  ){
                    count++;
                }
            }
        }
        return count ;
    }
    
    public void dfs(int i, int j , int[][] grid){
        grid[i][j]  = -1 ; 
        int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
        for(int d = 0 ; d < 4 ;d++){
            int r = i + dir[d][0] ;
            int c = j + dir[d][1] ;
            if(r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 1 ){
                dfs(r,c,grid);
            }
        }
    }
}