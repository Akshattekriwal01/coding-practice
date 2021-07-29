/*
 * iven a string S of lowercase letters.

You need to find as many substrings from the S that meets the following conditions.

no overlap among substrings
one letter can only exist in one substring. For every letter C in a substring, all occurrences of 
the letter C also need to be in that substring.
you want to find as many as substrings possible
If there are two solutions with the same number of substrings, return the one with a smaller total length.
Input
The input consists of one argument:

S: a string of lowercase letters

Output
Return substrings as a list.

Examples
Example 1:
Input:
S = "baddacxb"

Output: ["bb", "a", "c", "x"]
Example 2:
Input:
S = "bbeadcxede"

Output: ["dd", "c", "x"]
Explanation:
Here ["adda", "c", "x"] is not considered a correct answer. Because the total length of ["dd","c", "x"] i
s 4, which is smaller than the total length of ["adda", "c", "x"], which is 6.*/


import java.util.* ; 
import org.junit.*;
public class findSubString {
	public static void main(String[] args) {
		String s = "bbeadcsede";
		System.out.println(partitionLabels(s));
	}
	public static List<String> partitionLabels(String str) {
		List<String> ans = new ArrayList<String>();
		// find the last occurence . 
		int last[] = new int[26]; 
		for(int i = 0 ; i < str.length() ; i++) {
			last[str.charAt(i) - 'a'] = i;
		}
		
		// use anchor and j 
		int anchor = 0 ; 
		int j = 0 ;
		for(int i = 0 ; i < str.length() ; i++) {
			j = Math.max(j, last[str.charAt(i) - 'a']);
			
			//if current occurence is the last occurence of a character 
			if(i == j) {
				ans.add(str.substring(anchor,j+1));
				anchor = j+1 ;
			}
		}
		
		
		return ans ;
	}
}
