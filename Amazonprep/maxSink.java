import java.util.*;
public class maxSink {
	static int m , n;
	static int mat[][];
	public static void main(String[] args) {
		int[][] matrix={{23, 9, 3, 14, 15, 1},{10, 2, 15, 5, 9, 10},{6, 6, 3, 4, 7, 15},{12, 1, 6, 11, 2, 5},{5, 14, 7, 1, 1, 20}};
		 System.out.println(maxSinkArea(matrix)); 

	}

	public static int maxSinkArea(int[][] matrix) {
    int[][]  dir = {{-1,0},{0,1},{1,0}, {0,-1}} ; 
     m = matrix.length ; 
     n = matrix[0].length ;
     mat = matrix;
    int[][] visited = new int[m][n];
    int max = 0 ;
    for(int i = 0  ; i < matrix.length; i++ ) {
        for(int j = 0 ; j < matrix[0].length ; j++){
            if(visited[i][j] == 0){
               int count =  dfs(dir, matrix, visited, i , j  );
               max = Math.max(count, max);
            }
        }
    }
    return max ;
}
public static int dfs(int[][] dir, int[][] matrix, int[][] visited , int row, int col ){
    visited[row][col] = 1 ;
    int count = 1 ;
    for(int d = 0 ; d < 4 ; d++){
    int r = row+dir[d][0];
    int c = col+dir[d][1];
        if(r>=0 && c>=0 && r < m && c < n && visited[r][c] == 0 && safe(dir,r,c,d) )
        count += dfs(dir,matrix,visited,row,col);
    }
    return count;
    
}
public static boolean safe(int[][] dir,int row, int col , int i){
    int j = 0 ; 
    if(i == 0) j = 3; 
    if(i == 3) j = 4;
    if(i == 1) j = 2;
    if(i == 2) j = 1;
	for(int d = 0 ; d < 4 ; d++){
    int r = row+dir[d][0];
    int c = col+dir[d][1];
    	if(d != j && r>=0 && c>=0 && r < m && c < n ) {
        if(mat[row][col] >= mat[r][c] ) return false;
    	}
    }
    return true;
}
}
// learn how to avoid stack over flow error in these kinds of questions. 
