import java.io.*;
	import java.util.*;

	public class Main {

	    public static void main(String[] args) throws Exception {
            Scanner sc = new Scanner(System.in);
            // int a = sc.nextInt();
            // int b =sc.nextInt();
            printMazePaths(0,0,sc.nextInt()-1 , sc.nextInt()-1,"");
	    }

	    // sr - source row
	    // sc - source column
	    // dr - destination row
	    // dc - destination column
	    public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {
	        if(dc-sc < 0 || dr -sr < 0){
	            
	        }else if ((dr-sr) == 0 && (dc-sc) ==0){
	            System.out.println(psf);
	        }else{
	            printMazePaths(sr,sc+1,dr,dc,psf+"h");
	            printMazePaths(sr+1,sc,dr,dc,psf+"v");
	        }
	    }

	}