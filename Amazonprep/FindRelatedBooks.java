
import java.util.*;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/discuss/interview-question/977214/amazon-oa-2020-find-related-products
//  image of question saved in the folder OA/ Amazon
public class FindRelatedBooks {
	public static void main(String[] args) {
		// making a proper adjecency list. 
		List<List<String>> al = new ArrayList<List<String>>();
		String [] products = {"1 2 3","5 2" , "6 7", "8 7",""};
		for(String s : products) {
			al.add(Arrays.asList(s.split("\\s+")));
		}
		System.out.println(findLargest(al));
	}
	
	// returns the largest island;
	// build adjecency ;
	// find the a node of the largest island. 
	// dfs from the node to find all other nodes. 
	public static List<String> findLargest(List<List<String>> items){
		// make adjecency list
		HashMap<String, List<String>> map =  new HashMap<String, List<String>>();
		for(List<String> list : items) {
			for(int i = 0 ;  i < list.size() ; i++) {
				List<String> l ;
				if(map.containsKey(list.get(i))) {
					l = map.get(list.get(i));
				}else {
					l =  new ArrayList<String>();
				}
				for(int j = 0 ; j < list.size() ; j++) {
					if(i != j) {
					 l.add(list.get(j));
					}
				}	
				map.put(list.get(i), l);
			}	
		}
  
		Set<String> visited = new HashSet<String>();
		List<String> ls = new ArrayList<String>();
		List<String> largest  = new ArrayList<String>();
		for(String key : map.keySet()) {
			dfs(key,map,ls,visited);
			if(ls.size() > largest.size()) {
				largest.clear();
				largest.addAll(ls);
			}
			ls.clear();
		}
		return largest;
	}
	public static void dfs(String key, HashMap<String,List<String>> map, List<String> ls , Set<String> visited ) {
		
		visited.add(key);
		ls.add(key);
		for(String neighbour : map.get(key)) {
			if(!visited.contains(neighbour)) {
				dfs(neighbour,map,ls,visited);
			}
		}
		return ;
	}

}








/* ONLINE SOLUTION (NOT TESTED)
List<String> res = new ArrayList<>();

public List<String> findLargestGroup(List<List<String>> items) {
	Map<String, Set<String>> map = new HashMap<>();
	Set<String> keys = new HashSet<>();
	for (List<String> lst : items) {
		keys.addAll(lst);
		for (int i = 1; i < lst.size(); i++) {
			map.putIfAbsent(lst.get(i), new HashSet<>());
			map.putIfAbsent(lst.get(i - 1), new HashSet<>());
			map.get(lst.get(i - 1)).add(lst.get(i));
			map.get(lst.get(i)).add(lst.get(i - 1));
		}
	}
	Set<String> visited = new HashSet<>();

	for (String k : keys) {
		if (!visited.contains(k)) {
			List<String> lst = new ArrayList<>();
			dfs(map, visited, k, lst);
			if (lst.size() > res.size()) {
				res = lst;
			}
		}
	}
	return res;
}

void dfs(Map<String, Set<String>> map, Set<String> visited, String k, List<String> lst) {
	if (!visited.add(k))
		return;
	lst.add(k);
	for (String nei : map.getOrDefault(k, new HashSet<>())) {
		dfs(map, visited, nei, lst);
	}
}
 */