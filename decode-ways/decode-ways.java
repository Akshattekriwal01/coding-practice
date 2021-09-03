class Solution {
    // also do backtracking version here to print all the numbers
    public int numDecodings(String s) {
       // ith index of memo stores the number of ways to decode s.substring(i);
        int[] memo = new int[s.length() + 1];
        Arrays.fill(memo, -1);
        helper( 0,s, memo);
        // for(int n : memo){
        //     System.out.print(","+n);
        // }
        return memo[0];
    }
    
    public int helper(int index, String s , int[] memo ){
        if( index >= s.length()){
            return memo[index] = 1 ; 
        }else if( memo[index] != -1){
            return memo[index] ; 
        }else{
            int count = 0 ;
                int n = Integer.parseInt(""+s.charAt(index));
                if(n >= 1 && n <= 9){
                   count+= helper(index+1,s, memo);
                if (index < s.length() - 1 ){
                    int m = Integer.parseInt(s.substring(index,index+2));
                   if(m >= 9 && m <= 26){
                       count += helper(index+2,s, memo);
                   }                            
                }
                }
 
            return memo[index] = count  ;
            }
        }
    }
