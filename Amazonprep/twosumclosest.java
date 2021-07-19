import java.util.*; 
public class twosumclosest {
		public static void main(String[] args) {
		int[][] arr1 = { {1,2000}, {2, 3000}, {3, 4000} } ;
		int[][] arr2 = { { 1, 5000 }, {2, 3000},{3,3000},{4,1000 } };
		int target = 5000;
		Comparator<int[]> comp = new Comparator<int[]>() {
			public int compare(int[] a,int[] b) {
				return Integer.compare(a[1],b[1]);
				}
			};
		
		Arrays.sort(arr1,comp);
		Arrays.sort(arr2,comp);
		int closest = findClosest(target,arr1,arr2);
		HashMap<Integer,List<Integer>> map1 = new HashMap<>();
		HashMap<Integer,List<Integer>> map2 = new HashMap<>();
		
		for(int[] x : arr1) {
			if(map1.containsKey(x[1])) {
				List<Integer> list = map1.get(x[1]);
				list.add(x[0]);
				map1.put(x[1],list);
			}else {
				List<Integer> list = new ArrayList<Integer>() ; 
				list.add(x[0]);
 				map1.put(x[1],list);
			}
		}
		for(int[] x : arr2) {
			if(map2.containsKey(x[1])) {
				List<Integer> list = map2.get(x[1]);
				list.add(x[0]);
				map2.put(x[1],list);
			}else {
				List<Integer> list = new ArrayList<Integer>() ; 
				list.add(x[0]);
 				map2.put(x[1],list);
			}
		}
		for(int x : map1.keySet()) {
			if(map2.containsKey(closest - x)) {
				List<Integer>  list2= map2.get(closest-x); 
				List<Integer> list1 = map1.get(x);
				allCombo(list1,list2);
			}
			
		}
		
		

		}
		
		public static void allCombo(List<Integer> list1, List<Integer> list2) {
			for(int i = 0 ; i < list1.size() ; i++) {
				for(int j = 0 ; j < list2.size() ; j++) {
					System.out.println(list1.get(i)+","+list2.get(j));
				}
			}
		}
		
		// sort both the arrays. 
		// find closest element using 2 pointer approach. 
		// make 2 maps(value , index)
		// loop in map and for each element find (closest-curr) in another map. 
		// add these 2 values in array. nlogn

		
		public  static int findClosest(int target, int [][] arr1, int[][] arr2) {
			int i = 0 ; 
			int j = arr2.length -1  ; 
			int currBest = Integer.MAX_VALUE ;
			int sum1 = 0;
			while(true) {
				int sum = arr1[i][1]+arr2[j][1]; 
				int difference = Math.abs(target - sum);
				if(difference < currBest) {
					currBest = difference ;
					sum1 = sum ;
				}
				if(sum > target) {
					j--;
				}else if (sum < target){
					i++ ;
				}else {
					break;
				}
				if(j < 0 || i >= arr1.length ) {
					break ;
				}
				
			}
			
			return sum1;
		}
	

}



