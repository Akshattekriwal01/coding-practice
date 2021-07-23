import java.util.*;

// similar to splitwise minimize cash flow.
public class smallestNegativeBalance {

    public static void print2D(int mat[][])
    {
        // Loop through all rows
        for (int i = 0; i < mat.length; i++) {
        	System.out.println();
            // Loop through all elements of current row
            for (int j = 0; j < mat[i].length; j++)
                System.out.print(mat[i][j] + " ");
        }
    }
	public static void main (String[] args) {
		//String [] debt = {"a b 2","b a 2","c a 5","b c 7","a b 4","a c 4"};
		String [] debt = {"a b 2","b a 1","c a 4","a c 3"};
		/*
		 *   a  b  c
		 * a0   -2  
		 * b2  0
		 * c
		 * 
		 * */
		HashMap<String,Integer> map = new HashMap<>();
		List<String> people = new ArrayList<String>();
		List<List<String>> record = new ArrayList<List<String>> ();
		int j = 0 ;
		for(int i = 0 ; i < debt.length ; i++) {
			List<String> rec = new ArrayList<String>();
			rec = Arrays.asList(debt[i].split("\\s+"));
			if(!map.containsKey(rec.get(0) ) ) {
				people.add(rec.get(0));
				map.put(rec.get(0),j++);
			}
			if(!map.containsKey(rec.get(1) ) ) {
				people.add(rec.get(1));
				map.put(rec.get(1),j++);
			}
			record.add(rec);
		}
		System.out.println(people);
		int[][] matrix = new int[map.size()][map.size()];
		for(List<String> rec : record) {
			int a = map.get(rec.get(0));
			int b = map.get(rec.get(1)) ;
			int money  = Integer.parseInt(rec.get(2));
			matrix[a][b] -= money ; 
			matrix[b][a] += money ;
		}
		
		int minSoFar =Integer.MAX_VALUE;
		List<Integer> minPerson = new ArrayList<Integer>();
		for(int i = 0 ; i < matrix.length ; i++) {
			int total = 0 ;
			for( int n : matrix[i]) {
				total += n ;
			}
			if(total < minSoFar) {
				minSoFar  = total ; 
				minPerson.clear();
				minPerson.add(i);
			}else if ( minSoFar == total) {
				minPerson.add(i);
			}
		}
		print2D(matrix);
		List<String> ans = new ArrayList<String>();
		for(int n : minPerson) {
			ans.add(people.get(n));
		}
		if(ans.size() == people.size()) {
			System.out.println("YOLO");
		}else {
			System.out.println(ans);
		}
			
	}
}
