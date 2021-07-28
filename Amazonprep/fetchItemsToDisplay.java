import java.util.*;

public class fetchItemsToDisplay {
	public static void main(String[] args) {
		int number = 3 ;
		String[] products = {"product1 10 5","product2 3 3","product3 17 4","product4 9 4","product5 1 5"};
		int sortKey = 1 ;
		boolean sortOrder = false ;
		int productsPerRow = 3 ;
		int rowNumber = 1 ;
		
		
		Comparator<String> comp = new Comparator<String>() {
			public int compare(String a, String b) {
				String[] str = a.split("\\s+");
				String[] str1 = b.split("\\s+");
				int ans ; 
				if(sortKey == 0) {
					ans = str[0].compareTo(str1[0]);
				}else if(sortKey == 1) {
					ans = Integer.compare(Integer.parseInt(str[1]),Integer.parseInt(str1[1]));

				}else {
					ans = Integer.compare(Integer.parseInt(str[2]),Integer.parseInt(str1[2]));
				}
				if(!sortOrder) {
					ans = -1*ans;
				}
				return ans;
			}
		};
		
		Arrays.sort(products,comp);
		
		List<List<String>> ll = new ArrayList<List<String>>();
		
		int i = 0 ; 
		while(i < products.length) {
			int j = productsPerRow ;
		List<String> list = new ArrayList<String>();
			while(j-- > 0 && i < products.length) {
				list.add(products[i].split("\\s+")[0]); 
				i++;
			}
			ll.add(list);
			
		}
		System.out.println(ll.get(rowNumber));
		
		
		}
		
	}

