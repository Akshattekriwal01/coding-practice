import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int num_of_paths = climb(sc.nextInt());
        System.out.println(num_of_paths);
    }
    public static int climb(int n){
        if(n<0){
            return 0;
        }
        else if(n == 0){
            return 1;
        }else{
            int num = 0;
            for(int i = 1 ; i <= 3 ; i++){
              num = num+  climb(n-i);
            }
            return num;
        }
    }

}