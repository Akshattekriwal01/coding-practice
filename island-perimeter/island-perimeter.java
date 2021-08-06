class Solution {
    public int islandPerimeter(int[][] grid) {
        int parameter = 0 ; 
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] == 1)
                parameter += findParameter(grid, i, j);
            }
        }
        return parameter ;
    }
    public int findParameter(int[][] grid, int i, int j){
        int ans = 0 ; 
        
        int[][] dir = {{-1,0},{0,1}, {1,0},{0,-1}};
        
        for(int d= 0 ; d < 4 ; d++){
            int r = i+dir[d][0] ;
            int c = j+dir[d][1] ;
            if(r < 0 || c < 0 || r >= grid.length  || c >= grid[0].length || grid[r][c] == 0 ){
                ans++ ;
            }
        }
        return ans ;
    }
}
/*



*/