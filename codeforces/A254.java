import java.util.*;
public class A254 {
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int m = sc.nextInt();
            char[][] board = new char[n][m];
            sc.nextLine();
            for(int i = 0 ; i < n ; i++){
                String s = sc.nextLine();
                for(int j = 0 ; j<m ; j++){
                    board[i][j] = s.charAt(j);
                }
            }

            helper(board,0,0);
        }

        public static boolean helper(char[][] board ,int r, int c ){
            if( r == board.length ){
                displayBoard(board);
                return true;
            }
            boolean count = false ;
            if(board[r][c] == '-'){
                int[] arr  = next(board, r ,  c );
                if(arr[0] == r && arr[1] == c) {
                displayBoard(board);   
                return true;
                }
                 r = arr[0]; 
                 c = arr[1];
            }
            int row = r ; 
            int col = c ; 
            if( c == board[0].length -1 ){
                col = 0;
                row = r+1;
            }else{
                col = c+1 ;
            }
      
                char[] options = {'B','W'};
                for(int i = 0 ; i < 2 ; i++){
                    if(isSafe(options[i],board,r,c)){
                    board[r][c] = options[i];
                    boolean flag =  helper(board,row,col);
                    if (flag){
                        return true;
                    }
                    board[r][c] = '.';
                    }
                }
            
            return false;
        }
        public static boolean isSafe(char color, char[][] board , int r , int c){
                int[][] dir = {{0,-1},{-1,0}};
                for(int d = 0 ; d < 2 ; d++){
                    int a =  r+ dir[d][0];
                    int b = c + dir[d][1]; 
                    if(a >=0 && b >=0 && a < board.length && b < board[0].length){
                        if(board[a][b] == color ){
                            return false; 
                        }
                }
        }
        return true;
    }
    public static int[] next(char[][] board, int r , int c ){
        int[] arr =new int[2];
        arr[0] = r; 
        arr[1] = c;
        for(int i = r ; i < board.length ; i++){
            for(int j = c ; j < board[0].length ; j++){
                if(board[i][j] == '.'){
                arr[0] = i; 
                arr[1] = j ;
                return arr;
              }
            }
        }
        return arr;

    }
    public static void displayBoard(char[][] board){
        for(char[] arr : board){
            for (char c : arr){
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
