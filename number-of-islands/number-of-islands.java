class Solution {
    public int numIslands(char[][] grid) {
     // breaks down to finding the number of components; 
        int m = grid.length ; 
        int n = grid[0].length ; 
        int count = 0 ; 
        boolean visited[][] = new boolean[m][n];
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n; j++){            
                if(grid[i][j] == '1' && !visited[i][j]){
                dfs(grid, visited , i , j);
                count++; 
                }
            }
        }
        return count ;
    }
    public void dfs(char[][] grid, boolean[][] visited, int r , int c ){
        int[][] dir = {{0,1}, {1,0}, {0,-1},{-1,0} };
        visited[r][c] = true ; 
        for(int d= 0 ; d < 4 ; d++){
            int m = r + dir[d][0]; 
            int n = c+ dir[d][1] ;
            if(m >=0 && n >=0 && m < grid.length  && n < grid[0].length && grid[m][n] == '1' && !visited[m][n] )
                dfs(grid, visited, m ,n );
        }
    }
}