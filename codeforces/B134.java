import java.util.Scanner;
import java.util.*;
public class B134 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int n1 = n; 
        int m = sc.nextInt();
        int[] planes = new int[m];
        for(int i = 0 ; i < m ; i++){
            planes[i] = sc.nextInt();
        }
        int[] planes2 = new int[m];
        for(int i = 0 ; i< planes2.length ; i++){
            planes2[i] = planes[i];
        }

        Arrays.sort(planes);

        int max  = 0; 
        int i = 0 ; 
        for(int u = 0 ; u<planes.length/2 ; u++){
            int temp = planes[u];
            planes[u] = planes[planes.length - 1 - u];
            planes[planes.length - 1 - u] = temp;
            
        }
        while( n > 0){
            n--;
            max += planes[i];
            planes[i]--;
            if((planes[(i+1)%planes.length] > planes[i])){
                i = (i+1)%planes.length;
            }
        }
        int min = 0 ; 
        int j = 0 ; 
        while( n1> 0 ){
            n1--;
            min += planes2[j]--;
            if ( planes2[j] == 0){
                j = (j+1)%planes2.length;
            }
        }
        System.out.println(max+" "+min);

    }
}         
