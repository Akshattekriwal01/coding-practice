class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        // using kahns algorithm 
        // the point with 0 indegree will be the start of the longest path
        
        int m = matrix.length ; 
        int n = matrix[0].length ; 
        int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};
        int[][] indegree = new int[m][n];
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
              for(int d = 0 ; d < 4 ;d++){
                  int r =  i + dir[d][0];
                  int c =  j + dir[d][1];
                  if(r < m && c < n && r >=0 && c >=0 && matrix[r][c] < matrix[i][j])
                      indegree[i][j]++;
              }  
            }
        }
        
          for(int r = 0 ; r < m ; r++){
            for(int c = 0 ; c < n ; c++){
              if(indegree[r][c] == 0 ){
                   q.add(r*n+c);
              }
            }
        }
        
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size() ;
            while(size-- > 0){
                int rem = q.poll() ;
                int i = rem / n ;
                int j = rem % n ;
              for(int d = 0 ; d < 4 ;d++){
                  int r =  i + dir[d][0];
                  int c =  j + dir[d][1];
                  if(r < m && c < n && r >=0 && c >=0 && matrix[r][c] > matrix[i][j]){ 
                   //neighbor found; 
                      // relax edge 
                     if( --indegree[r][c] == 0){
                         q.add(r*n+c);
                     }
                  }
                     
              }   
              
            }
            level++; 
          }
        return level;
        }
}