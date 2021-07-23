import java.util.*;
public class HighestProfit {
	public static void main(String[] args) {
		int[] arr ={10,10} ;
		int order = 5 ;
		PriorityQueue<Integer>  pq = new PriorityQueue<>(new Comparator<Integer>() {
			public int compare(Integer a , Integer b) {
				return -1*Integer.compare(a, b);
			}
		});
		for(int  n : arr) {
			pq.add(n);
		}
		int count = 0 ;
		while( order > 0 && !pq.isEmpty()) {
			int max = pq.poll();
			count += max;
			pq.add(max-1);
			order--;
		}
		System.out.println(count); ; 
	}
	public static double calc(int a, int b) {
		return ((double)a*(a+1)/2) - ((double)b * (b+1)/2) ;
	}
}