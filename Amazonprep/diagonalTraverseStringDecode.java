/*You are given an encoded string  and number of rows, Convert it to original string
  
 Input: mnesi___ya__k____mime  N = 3
  
 Output : my name is mike

 Explanation : Read the matrix in a diagonal way starting from [0][0] index until the end of row and start from the top
 again to decode it. _ are treated as space.
 
 m n e s i _  _
      
  _ y a _ _ k _
 	   
  _ _ _ m i m e
 * 
 * 
 * */
public class diagonalTraverseStringDecode {
	public static void main(String [] args) {
	String input = "mnesi___ya__k____mime";
	int n = 3 ;
    System.out.println(decode(input,n));
	}
	public static String decode(String input, int n) {
		char[][] matrix = new char[n][input.length()/n];
		int i = 0 ;
		int row = 0 ;
		int j = 0 ; 
		while(row < n) {
			if(i == input.length()/3) {
				i = 0 ; 
				row++;
				if(row == n) break ;
			}
			char c = input.charAt(j++);
			matrix[row][i] = c ;
			i++;
		}
		 //disp(matrix);
		 return helper( matrix);
		 
	}
	// diagonal traversal code that i dont like . lemme find a better way.
	public static String helper(char [][] matrix) { 
		String ans = "";
		int i = 0 ;
		int j = 0 ;
		while(i < matrix.length && j < matrix[0].length) {
			int cache = j ;
			while(i < matrix.length && j < matrix[0].length) {
				ans += matrix[i][j] == '_'? ' ': matrix[i][j];
				j++ ;
				i++ ;
			}
			
			if(i == matrix.length) {
				i = 0 ;
				j= cache + 1 ;
			}
		}
		return ans.trim();
	}
	public static void disp(char[][] matrix) {
		for(char[] n : matrix) {
			for(char i : n) {
				System.out.print(i);
			}
			System.out.println();
		}
	}
}
