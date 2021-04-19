import java.io.*;
import java.util.*;
// No OBSTACLE
public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        printMazePaths(0,0,sc.nextInt()-1, sc.nextInt()-1,"");
       
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {

      if(sc == dc && sr == dr){
            System.out.println(psf);
        }else{
            int maxHorizontalJumps = dc - sc ;
            int maxVerticalJumps = dr -sr ;
            int maxDiagonalJumps = Math.min(maxHorizontalJumps,maxVerticalJumps);
            for(int i = 1 ; i <= maxHorizontalJumps ; i++  ){
        
            printMazePaths(sr,sc+i,dr,dc,psf+"h"+i);
                
            }
            for(int j = 1 ; j <= maxVerticalJumps ; j++  ){
            printMazePaths(sr+j,sc,dr,dc,psf+"v"+j);
                
            }
            for(int k = 1 ; k <= maxDiagonalJumps ; k++  ){
            printMazePaths(sr+k,sc+k,dr,dc,psf+"d"+k);
                
            }
        }
    }

}