import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
      Scanner sc = new Scanner(System.in);
      printStairPaths(sc.nextInt(),"");
    }

    public static void printStairPaths(int n, String path) {
        if(n < 0){
            
        }else if(n==0){
            System.out.println(path);
        }else{
            for(int i= 1 ; i <=3 ; i++){
            String p= path;
                     
                printStairPaths(n-i,p+i);
            }
        }
    }

}

// O(3^n)
