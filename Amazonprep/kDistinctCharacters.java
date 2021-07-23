/**
 * 
 * Given a string s and an int k, return an int representing the number of substrings (not unique) of s with exactly k distinct characters. If the given string doesn't have k distinct characters, return 0.
https://leetcode.com/problems/subarrays-with-k-different-integers

Example 1:

Input: s = "pqpqs", k = 2
Output: 7
Explanation: ["pq", "pqp", "pqpq", "qp", "qpq", "pq", "qs"]
 * 
 * */



import java.util.*;
public class kDistinctCharacters {
	public static void main(String[] args) {
	String  s = "pqpqs"; int len = 2;
	// FIND AT MOST K DISTANT - AT MOST (K-1) DISTANT
	int ans = helper(s,len) - helper(s,len-1)  ;
	System.out.println(ans);
	}

	public static int helper(String s , int len ) {

		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		
		int count = 0 ;
		
		int j = 0 ;
		int i = 0 ;
		int k = 0 ;
			while(j < s.length()) {
				char c = s.charAt(j);
				
				if(!map.containsKey(c)) {
					map.put(c,1);
				
				}else {
					map.put(c, map.get(c)+1);
				}
				
			
				if(map.size() > len) {
					
				 while( map.size() > len) {
					char ch = s.charAt(i);
					
					map.put(ch, map.get(ch)-1);

					if(map.get(ch) == 0) {
						map.remove(ch);
					}
					
					i++;
				  }
				}
				
				if(map.size() <= len) {
					//System.out.println(map);
					count += (j-i+1) ;
				}
				j++;
			}
			return count ;
	}
}
