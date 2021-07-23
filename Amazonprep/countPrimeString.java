import java.util.*;
public class countPrimeString {
	
	public static void main(String[] args) {
		String str = "317"; 
		// 3 , 1 ,7  == x this aint prime. 
		// 31 , 7
		// 3 , 17
		// 317
		int ans = helper(str,0);
		System.out.println(ans);
	}
	public static int helper(String  str, int index) {
		if(0 == str.length() ) {
			return 1 ; 
		}else  { 
			int count = 0 ;
			for(int i = 0 ; i <str.length()  ; i++) {
				String s =  str.substring(0,i+1);
				String remaining = str.substring(i+1);
				if(isPrime(Integer.parseInt(s))) {
					System.out.println(s);
					count += helper(remaining,index+1);
				}
		  }
			return count ;
		}
	}
	public static  boolean isPrime(int num) {
		
		double root = Math.sqrt(num);
		if (num == 1 ) {
		return false;
		}
		for(int i =2 ; i <= root; i++) {
			if ( (num % i ) == 0) {
				return false;
			}
		}
		return true;
	}
	
}
  /*     					    31175
       						3/  31|  317 \   
       					 1175    75       5
       				    x 1/ \11  7|
       					175  75   5
       				   1/
       				   75
       				 7/
       				 5
       				/ 
       			   ""

*/