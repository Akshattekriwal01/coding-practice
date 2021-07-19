
import java.util.*;
/**
 * An olive oil seller needs to measure oil; for customers using only one type of flask. 
 * There are many flasks available, each with marking at various levels. Each customer must receive a flask filled to a mark
 *  that is atleast equal to the amount ordered. Given a list of customer requirements and a list of flasks
 *   with their measurements, determine the single type of flask that will result in the minimal loss to the merchant.
 *    Loss is the sum of marking – requirement for each order. Return the zero-based index of the flask type chosen. 
 *   If there are multiple answers, return the minimum index. If no flask will satisfy the constraints, return -1.
 *   
 *   
 *   For example, there are n=4 orders for requirements = [4, 6, 6, 7] units of oil. There are m=3 
 *   types of flask available with markings = [“3 5 7”, “6 8 9”, “3 5 6”]. These markings are given
 *    as 2D array with total_marks rows and 2 columns, first is the index of flask and second the mark.
 *     To fill the orders using the flask at markings[0] = [3,5,7], the loss is calculated as marking 
 *     requirement for each order so, 5-4=1, 7-6=1 and 7-7=0. The total loss then is 1+1+1+0=3. 
 *     Choosing the flask at markings[1], the loss is 6-4=2, 6-6=0, 8-7=1 -> 2+0+0+1 = 3. The third 
 *     flask has a maximum mark at 6 which is smaller than the largest order, so it cannot be used. 
 *     In this case, flask type 0 is chosen.
 * Note ! The markings 2d array will be given in order of the flasks, i.e the markings for the 0-index 
 * flask will be followed by markings of 1-index flask and so on. For each flask, the given markings will also be in the sorted order.

*Constraints

1 <= n <= 100

-1 <= mat[i][j] <= 1

Sample Input 0
2
4
6
2
5
2
0 5
0 7
0 10
1 4
1 10
Sample Output 0 :
0
 * */
public class ChooseFlask {
		public static void main(String[] args) {
			  int[][] marking = {{3,5,7,},{6,8,9},{3,4,5}};
			  int[] requirement = {4,6,6,7};
			  Arrays.sort(requirement);
			  // 1+5+5+4+1 = 16 
			  //2+2+2+1+0 = 7
			   int minLoss = Integer.MAX_VALUE;
			  for(int[] flask : marking) {
				  int loss = lossCalculator(flask,requirement);
				 // System.out.println(loss);
				   if(loss != -1) {
					   minLoss = Math.min(minLoss,loss);
				   }
				
			  }
			  minLoss = minLoss == Integer.MAX_VALUE ? -1 : minLoss ;
			  System.out.println(minLoss);
			  
		}
		public static int lossCalculator( int[] marking, int[] requirement) {
			int loss = 0 ;
//			for(int req : requirement) {
//				int num = closestBigger(req,marking);
//				
//				if(num == -1 ) {
//					return -1 ;
//				}else {
//					loss += (num - req); 
//				}
//			}
//			return loss;
						int i = 0 ; 
			int j = 0 ; 
			while(j < requirement.length) {
				while( i < marking.length && marking[i] < requirement[j]) {
					 i++;
				}
				if(i == marking.length) return -1 ;
				loss += (marking[i] - requirement[j]);
				j++;
			}
			return loss ;
		}
		// can be done without binary search ;
		// returns closes bigger number or negative 1 ;
		///[F,T,T](t);
		public static int closestBigger(int target, int[] arr) {
			int left = 0 ; int right = arr.length;
			while(left < right) {
				int  mid = left +(right - left )/2;
				if(arr[mid] < target) {
					left = mid + 1;
				}else {
					right = mid ;
				}
			}
			 return left == arr.length ? - 1  :  arr[left] ;
		}
}
