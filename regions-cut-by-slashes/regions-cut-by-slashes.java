class Solution {
    public int regionsBySlashes(String[] grid) {
        int n = grid[0].length() ;
        int[][] matrix = new int[n*3][n*3]; 
        
        for(int i = 0 ; i < n ; i++ ){
            String s = grid[i];
            for(int j = 0 ; j < n ; j++){
                char c = s.charAt(j);
                
                if( c == '\\' ){
                    matrix[3*i][3*j] = 1 ;
                    matrix[3*i+1][3*j+1] = 1 ;
                    matrix[3*i+2][3*j+2] = 1 ;
                }
                else if (c == '/'){
                    matrix[3*i][3*j+2] = 1 ;
                    matrix[3*i+1][3*j+1] = 1 ;
                    matrix[3*i+2][3*j] = 1 ;
                }
                else {
                    
                }
            }
        }
        return gcc(matrix);
    }
    public int gcc(int[][] grid){
        //display(grid);
        int m = grid.length ; 
        int n = grid[0].length ;
        int count = 0 ;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
              if(grid[i][j] == 0){
                  bfs(i,j,grid);
                   count++;
              }  
            }
        }
        return count ;
    }
    public void bfs(int i , int j ,int[][] grid){
            int m = grid.length ; 
        int n = grid[0].length ;
          Queue<Integer> q = new LinkedList<Integer>() ;
        // can't detect cycle in they type of bfs.
          q.add(i * n + j) ;
           grid[i][j] = -1 ;
        while(!q.isEmpty()){
            int rem = q.poll() ; 
            int x = rem / n ;
            int y = rem % n ;
            
            int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
            
            for(int[] d : dir){
                int r = x + d[0];
                int c = y + d[1];
                
                if( r >= 0 && c >= 0 && r < m && c < n && grid[r][c] == 0  ){
                    q.add(r * n + c);
                    grid[r][c] = -1 ;
                }
            }
            
        }
    }
    
    public void display(int[][] grid){
        for(int[] arr: grid){
            for(int n : arr){
                System.out.print(n);
            }
             System.out.println();
        }
    }
}

/*
'. ./.'
'./. .'

0001
0010
0100
1000

001
010
100

100
010
001

1010
0101
1010
0101


*/