// with memo O(n*n)
// space O(n)  stack + memo

import java.io.*;
import java.util.*;
import java.lang.*;
public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        System.out.println(climbstairMin( arr, 0, memo));
    }
    
    public static int climbstairMin(int[] arr, int currStep, int[] memo){
        
           if(currStep > arr.length ){
               return 999999;    
           }
         else if(currStep == arr.length){
            return 0;   // base case returns 0;
         }else if (memo[currStep] != -1){
             return memo[currStep];
         }
         else{
            int min = 99999; // this should be greater than the min.
            for(int i = 1 ; i <= arr[currStep]  ; i ++){
            min = Math.min(climbstairMin(arr,currStep + i, memo ),min); 
            //System.out.println(""+currStep+" "+min);
            }
            return 1+min;
          
        }
    }
    
    
    
    

}