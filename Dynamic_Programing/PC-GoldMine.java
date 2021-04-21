import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       int m = sc.nextInt();
       int[][] matrix = new int[n][m];
       for(int i = 0 ; i < n ; i++){
           for(int j = 0 ; j < m ; j++){
               matrix[i][j] = sc.nextInt();
               
           }
       }
       int[][] memo =  new int[n][m];
       for(int[] x : memo){
           Arrays.fill(x,-1);
       }
      System.out.println( minCostPath(matrix, n-1,m-1,n-1,m-1,memo));
    }
    
    public static int minCostPath(int[][] matrix , int sr, int sc, int dr, int dc, int[][] memo){
       
        if(sr < 0 ||  sc < 0){  // exceed condition
            return 999999;
        }else if (sr == 0 && sc == 0){ // meeting condition
            return matrix[sr][sc];
        }else if (memo[sr][sc] != -1){
            return memo[sr][sc];
        }else{
       
          memo[sr][sc] = matrix[sr][sc]+ Math.min(minCostPath(matrix,sr-1,sc,dr,dc,memo) ,   minCostPath(matrix,sr,sc-1,dr,dc,memo));
          return memo[sr][sc];
           
        }
    }
    

}
