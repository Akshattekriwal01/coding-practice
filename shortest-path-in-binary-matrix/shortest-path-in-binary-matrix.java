/*
Take Away.
a. in 8 directional grid. level != shortest path. 
b. when finding these paths types of question . when we add the first element to the q. check is it is a valid element
c. Do the "Work" part of a cyclic bfs outside the "add neighbour loop"; 
c. know what does to exit while loop in bfs. 
d. 2d bfs is easier to debug and understand .
*/

class Solution {
    
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        Queue<int[]> q = new  LinkedList<int[]>() ; 
        int rows = grid.length; 
        int columns = grid[0].length ; 
        int[] arr = new int[2]; // i,j,count
        
        arr[0] = 0 ; 
        arr[1] = 0 ; 
        int shortestPath = 1 ;
        if(grid[0][0] == 0 )
            q.add(arr); 
        
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
            int[] rem = q.poll(); 
            
               if( rem[0] == (rows-1) && rem[1] == (columns-1) ) return shortestPath ; 
            
            int dir[][] = {{-1,-1}, {-1,0}, {-1,1},{0,1}, {1,1}, {1,0}, {1,-1}, {0,-1}};
                for(int d = 0 ; d < 8 ; d++){
                    int r = rem[0] + dir[d][0] ;
                    int c = rem[1] + dir[d][1] ;
                    
                 
                    
                    if( r < rows && c < columns && r >= 0 && c >= 0 && grid[r][c] == 0){
                        int [] arr1 = new int [2]; 
                        arr1[0] = r ;
                        arr1[1] = c ; 
                        q.add(arr1) ;
                        grid[r][c] = 1 ; 
                        
                        
                    }
                }
            }
            shortestPath++ ;
        }
        /*[1,0,0],
          [1,1,0],
          [1,1,0]
        */
        return -1; // when we reach here means that during the bfs 
                        // a. the element was present but could't be reached . 
                        // b. the element was not present .
    }
}