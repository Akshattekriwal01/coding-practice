import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i  = 0 ; i < n ; i++){
                arr[i] = sc.nextInt();
            }
            int[] memo = new int[n];
            Arrays.fill(memo,-1)    ;
            System.out.println(climbStair(arr,0,memo));
    }
    //[2,4,2,1,4,0] 
    public static int climbStair(int[] arr, int currStep,int[] memo){
        if(currStep > arr.length){
            return 0;
        }
        else if(currStep == arr.length){
            return 1 ;
        }else if (memo[currStep] != -1){
            return memo[currStep];
        }else{
           
            int path = 0; 
            // REMEMBER EQUAL OR LESS than is very important.
            for(int i = 1 ; i <=  arr[currStep] ; i++){
                
                path +=climbStair(arr,currStep+i,memo);
               
            }
             memo[currStep] = path;
            return  memo[currStep] ;
        }
    }

}