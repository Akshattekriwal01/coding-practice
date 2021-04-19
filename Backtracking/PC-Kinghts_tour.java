import java.io.*;
import java.util.*;

public class Main {
      static int[] x = {-2,-1,1,2,2,  1,-1,-2};
        static int[] y = {1,  2,2,1,-1,-2,-2,-1};
        static int[][] chess ;
        static int size ;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
       size = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        chess= new int[r][c];
        for(int[] x: chess){
            Arrays.fill(x,0);
        }
        chess = new int[size][size] ; 
        chess[r][c] = 1 ;
        printKnightsTour(chess,r,c,2);
    }

   

    public static void displayBoard(int[][] chess){
        for(int i = 0; i < chess.length; i++){
            for(int j = 0; j < chess[0].length; j++){
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }
    public static boolean isSafe(int[][] chess ,int r ,int c){
        int ROW = chess.length;
        int COLUMN = chess[0].length;
        return ( r >= 0 && c >=0 && r < ROW && c < COLUMN && chess[r][c]==0 );
    }
    public static boolean good(int chess[][]){
        for(int i = 0 ; i <size ; i++){
            for(int j = 0 ; j < size; j++){
                if(chess[i][j] == 0){
                    return false;
                }
            }
        }
        return true;
    }
    public static void printKnightsTour(int[][] chess, int r, int c, int movesMade) {
     if(movesMade == ((size*size)+1) && good(chess)){
        displayBoard(chess); 
     }else{
       for(int i = 0 ; i < 8 ; i ++){
           if(isSafe(chess,r+x[i],c+y[i])){
              chess[r+x[i]][c+y[i]] = movesMade ;
              printKnightsTour(chess,r+x[i],c+y[i],movesMade+1); 
              chess[r+x[i]][c+y[i]] = 0 ;
           }
       }
     }
        
    }
}