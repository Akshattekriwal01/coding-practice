import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class treasureIsland1 {
	public static void main(String args[]) {
		char[][] grid = 
			{{'O', 'O', 'O', 'O'},
		 {'D', 'O', 'D', 'O'},
		 {'O', 'O', 'O', 'O'},
		 {'O', 'D', 'D', 'X'}} ;
		
		try {
			
		assertEquals(7,minSteps(grid)); // An error will be thrown and usually it's not cachted and the progrma is terminated. 
	
		}catch(AssertionError e) {
		 
			e.printStackTrace();
			 
		}
	}
	
	
	public static int minSteps(char grid[][]) {
		int m = grid.length ;
		int n = grid[0].length;
		boolean[][] visited = new boolean[m][n];
		
		// 0 is x , 1 is y ; 
		int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};
		
		Queue<int[]> q = new LinkedList<>();
		int[] arr = new int[2];
		arr[0] = 0;
		arr[1] = 0;
		q.add(arr);
		visited[0][0] = true ;
		int count = 0 ; 
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i = 0 ; i < size ; i++) {
				int[] arr1 = q.poll();
				int x = arr1[0];
				int y = arr1[1];
				 if(grid[x][y] == 'X') {
					 return count ;
				 }
				for(int d = 0  ; d < 4 ; d++) {
					int r = x + dir[d][0] ;
					int c = y + dir[d][1] ; 
					
					if(r >= 0 && c >=0 && r < m && c < n && !visited[r][c] && grid[r][c] != 'D') {
						int arr2[] = {r,c}; 
						q.add(arr2);
						visited[r][c] = true ;  // dont forget to visit the neighbour when doing this. 
					}
				}
				
			}
		   count ++ ;
		}
		return -1 ;
  }
}
