import java.util.*;

/**
 * Amazon Fresh Deliveries
Given allLocations list of co-ordinates (x,y) you have to find the X - closest locations from truck's location which is (0,0). Distance is calculated using formula (x^2 + y^2).
If the there is tie then choose the co-ordinate with least x value.
Sample Input :
allLocations : [ [1, 2] , [1, -1], [3, 4] ]
numOfDeliveries : 2
Sample Output :
[ [1, -1], [1 , 2] ]
Output list can be in any order.
This question was basically K closest points to the origin (0,0) with added tie condition.
*/



public class FreshDeliveries {
		public static void main(String[] args) {
		int[][] allLocations = {{4,3},{3,2},{2,3},{1,2},{3,4}};
		int n = 2 ; 
		
		// write this priority que with comparator once more . 
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
		public int compare(int[] a, int[] b ) {
			int x1,y1,x2,y2 ; 
			x1 = a[0];
			x2 = b[0];
			y1 = a[1];
			y2 = b[1];
			// calculating 2 distance because this is the basis of comaprision of priotity queue;
			
			int dist1 = x1*x1 + y1*y1 ;
			int dist2 = x2*x2 + y2*y2 ;
			int ans =  -1 * Integer.compare(dist1, dist2);
			if(ans == 0 ) {
				return -1 * Integer.compare(x1,x2);
			}
			return ans ;
			
		}
				
		});
			

		
		
		for(int[] location : allLocations) {
			pq.add(location);
			if(pq.size() > n) {
				pq.poll();
			}
		}
		
		for(int[] arr : pq) {
			System.out.println(arr[0]+","+arr[1]);
		}
		
		// priorrity queue declaration that works on this basis ; 
		
		PriorityQueue<int[]> pq1 = new PriorityQueue<int[]>(new Comparator<int[]>() {
			public int compare(int[] a , int[] b) {
				return 0 ; 
			}
		});
		
		
		}
		
	
}
