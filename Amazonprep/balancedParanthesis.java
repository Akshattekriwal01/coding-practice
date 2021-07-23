import java.util.*;
/*
 * Kindle Direct Publishing, Amazon's e-book selfpublishing platform, is working on a new feature to 
 * help authors use special text characters in different ways. 
 * They have asked for your help in beta testing a new part of the feature involving round and
 *  square brackets. Given a string that consists of characters (, ), [, ] and ?,
 *   determine how many ways it can be split into two non-empty substrings such that the
 *   e characters in each substring can be rearranged into a balanced string. 
 *   A sequence of round and square brackets can be rearranged into a balanced sequence if 
 *   and only if the number of opened and closed bracket is equal for both types of the brackets. 
 *   The question marks can take the place of any needed character,
 *    and the substrings together must contain the entire string.
 *    
Note: A substring is a contiguous group of characters in a string.
Sample Case 1
Sample Input For Custom Testing
STDIN
Function
– – – – –
(((?
i can have  4 arrays to keep count of each until a specific index. 

s = '(((?'
Sample Output
Explanation s = (((?
There are 3 splits into two non-empty substrings:
(and (? 2.(( and (? 3.((( and ?
None has two balanced substrings.
 * */
public class balancedParanthesis {
	     static String s = "()?()";
		public static void main(String[] args) {
			
			HashMap<Character,int[]> map = new HashMap<Character,int[]>();
			map.put('(',new int[s.length()]);
			map.put(']',new int[s.length()]);
			map.put('[',new int[s.length()]);
			map.put(')',new int[s.length()]);
			map.put('?',new int[s.length()]);
			
			int[] arr = map.get(s.charAt(0)) ;
			arr[0] = 1 ;
			for(int i = 1 ; i < s.length()-1 ; i++) {
				for(Character c : map.keySet()) {
					int[] arr2 = map.get(c);
					arr2[i] = arr2[i-1];
				}
				int[] arr1 = map.get(s.charAt(i));
				arr1[i]++; 
			}
			
			int count = 0 ;
			for(Character c : map.keySet()) {
				System.out.println(c) ;
				for(int n : map.get(c)) {
					System.out.print(n) ;
				}
				System.out.println() ;
			}
			for(int i = 0 ;  i < s.length() ; i ++) {
				if(leftBalanced(i,map) && rightBalanced(i,map)) {
					count ++;
				}
			}
	
			System.out.println(count) ;
		}
		public static boolean leftBalanced(int i,HashMap<Character,int[]> map) {
			int star = map.get('?')[i];
			int openCurly = map.get('(')[i];
			int closeCurly = map.get(')')[i];
			int openSquare = map.get('[')[i];
			int closeSquare = map.get(']')[i];
			if(star >= Math.abs((closeSquare - openSquare ) + (closeCurly - openCurly)) ){
				 return true;
			 }else return false ;
		}
	   public static boolean rightBalanced(int i,HashMap<Character,int[]> map) {
			int star = map.get('?')[s.length()-1] - map.get('?')[i];
			int openCurly = map.get('(')[s.length()-1]-map.get('(')[i];
			int closeCurly = map.get(')')[s.length()-1]-map.get(')')[i];
			int openSquare = map.get('[')[s.length()-1]-map.get('[')[i];
			int closeSquare =map.get(']')[s.length()-1]- map.get(']')[i];
			 if(star >= Math.abs((closeSquare - openSquare) + (closeCurly - openCurly)) ){
				 return true;
			 }else return false ;
		   
		
		}
		
}
