import java.util.HashMap;
import java.util.Scanner;
import java.util.*;
class B261{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        
        Arrays.sort(arr);
        int diff = arr[n-1]-arr[0];
        HashMap<Integer,Integer> map = new HashMap<>(); 
        int count = 0;
        for(int a = 0  ; a < n ; a++){
            int key = arr[a] - diff; 
            
            if(map.containsKey(key)){
                count += map.get(key);
            }
            map.put(arr[a], map.getOrDefault(arr[a], 0)+1);
        }

        System.out.println(diff+" "+count);
    }
}