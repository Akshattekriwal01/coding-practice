import java.util.Collections;
import java.util.*;
/*You are given an List of positions of cars as to where they are parked. You are also given an integer K. 
 The cars needs to be covered with a roof. You have to find the minimum length of roof that takes to cover K cars.
 
 Input : 12,6,5,2      K = 3
 
 Explanation :  There are two possible roofs that can cover K cars. One that covers the car in 2,5,6 parking spots and
 another roof which covers 5,6,12 parking spots. The length of these two roofs are 5 and 8 respectively. Return 5
 since that's the roof with minimum length that covers K cars.

 Output : 5
 * */

// O(nlogn)
public class parkingLot {
	public static void main(String[] args) {
		int[] arr = {1,2,3,10};
		int k = 4 ;
		
		int i = 0 ; 
		int j = 0 ;
		
		Arrays.sort(arr);
		int currLen = 0 ;
		int minLength = 100000;
		while(j<arr.length) {
			
			currLen = arr[j] -arr[i] + 1;
			if(j-i+1 == k) {
				 minLength = Math.min(minLength, currLen);
				i++;
			}
			
			j++;
		}
		System.out.println(minLength) ;
	}
}
