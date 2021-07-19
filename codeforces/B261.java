import java.util.HashMap;
import java.util.Scanner;
import java.util.*;
public class B261{
    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        int n =sc.nextInt();
//        int[] arr = new int[n];
//
//        for(int i = 0 ; i < n ; i++){
//            arr[i] = sc.nextInt();
//        }
        
//        Arrays.sort(arr);
//        int diff = arr[n-1]-arr[0];
//        HashMap<Integer,Integer> map = new HashMap<>(); 
//        long count = 0;
//        for(int a = 0  ; a < n ; a++){
//            int key = arr[a] - diff; 
//            
//            if(map.containsKey(key)){
//                count += map.get(key);
//            }
//            map.put(arr[a], map.getOrDefault(arr[a], 0)+1);
//        }

//    	Stack st = new Stack();
//    	st.push(1);
//    	st.push(1.1);
//    	foreach()
boolean b1 = true ;
boolean b2 = false ; 
boolean b3 = true ; 
if(b1 & b2 | b2 & b3 | b2 ) System.out.print("a");
if(b1 & b2 | b2 & b3 | b2 | b3 ) System.out.print("b");

//    	B b = new B();
//        System.out.println(b instanceof B);
//        System.out.println(b instanceof A);
//        System.out.println(b instanceof C);


    }
}
class A{}
class B extends A {}
class C extends B {}


