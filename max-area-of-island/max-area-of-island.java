class Solution {
        int[] x ={0,1,0,-1} ;
        int[] y = {-1,0,1,0} ;
    public int maxAreaOfIsland(int[][] grid) {
  
        
        boolean[][] visited = new boolean[grid.length ][grid[0].length];
        
        int area = 0;
        for(int i =0 ; i < grid.length ; i++){
            for(int j = 0  ; j< grid[0].length ; j++){
                if(grid[i][j] != 0){
                    area = Math.max(area,dfs(i,j,visited,grid));
                }
            }
        }
        return area;
    }
    
    
    public int dfs(int r, int c , boolean[][] visited,int[][] grid){
      
        visited[r][c] = true;
       int count = 0;
       for(int i =0 ; i< 4; i++){
        if(isSafe(r+x[i],c+y[i],visited , grid)){
          count = count+  dfs(r+x[i], c+ y[i],visited,grid);  // add all the answers to the count .       
        }    
       }
        count = count + 1;  // adding itself to the count ;
        return count;
       
    }
    
    public boolean isSafe(int r , int c , boolean[][] visited,int[][] grid){
       int R = visited.length;
        int C = visited[0].length;
        return ( r>=0 && c>=0 && r<R && c<C && visited[r][c]==false && grid[r][c] != 0);
    }
}