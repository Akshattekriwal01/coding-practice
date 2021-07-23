import java.util.*;
/**
 * Given a string s and an int k, return all unique substrings of s of size k with k distinct characters.

Example 1:

Input: s = "abcabc", k = 3
Output: ["abc", "bca", "cab"]
Example 2:

Input: s = "abacab", k = 3
Output: ["bac", "cab"]
Example 3:

Input: s = "awaglknagawunagwkwagl", k = 4
Output: ["wagl", "aglk", "glkn", "lkna", "knag", "gawu", "awun", "wuna", "unag", "nagw", "agwk", "kwag"]
Explanation: 
Substrings in order are: "wagl", "aglk", "glkn", "lkna", "knag", "gawu", "awun", "wuna", "unag", "nagw", "agwk", "kwag", "wagl" 
"wagl" is repeated twice, but is included in the output once.
Constraints:

The input string consists of only lowercase English letters [a-z]
0 ≤ k ≤ 26

 * 
 * */
// FIXED WINDOW SIZE PATTERN
public class kdistinctCharsOfLenK {
	public static void main(String[] args) {
		String s = "abcabc" ;
	 	int k = 3 ;
	 	
	 	System.out.println(helper(s,k)) ;
	}
	public static List<String> helper( String s , int k ) {
		HashMap<Character,Integer> map = new HashMap<>();
		HashSet<String> set = new HashSet<String>();
		
		int i = 0 ; 
		int  j  = 0 ;
		int ans = 0 ;
		while(j < s.length()) {
			char c  = s.charAt(j);
			if(!map.containsKey(c)) {
				map.put(c , 1);
			}else {
				map.put(c, map.get(c)+1);
			}
			
			//1 2 3 4
			//  ^ ^
			if(j-i+1 == k) {
				
				if(map.size() == k)
				set.add(s.substring(i,j+1));
				
				char ch  = s.charAt(i);
				if(map.containsKey(ch)) {
					map.put(ch,map.get(ch)-1);
				}
				if(map.get(ch) == 0 ) {
					map.remove(ch);
				}
				i++;
			}
	
				
			 j++;
				
			
			
		}
		List<String> d = new ArrayList<String>(set);
		return d ; 
	}
 
}
