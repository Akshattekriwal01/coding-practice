/*
12 + -34 -(4-5+2+(6+8))-3
                         i
sing = -1 
sum = -38
stack -> [
*/
class Solution {
    public int calculate(String s) {
        int i = 0 ; 
        int sign = 1 ;
         int sum = 0 ;
        Stack<Integer> stack = new Stack<Integer>() ;
        while( i < s.length()){
            if(Character.isDigit(s.charAt(i))){
              int val = 0 ;
              while(i < s.length() && Character.isDigit(s.charAt(i))){
                val = val * 10 + (s.charAt(i) - '0' );
                i++;
              }
            i--;
            sum += (sign * val) ;
            sign = 1 ;
            }
            else if (s.charAt(i)== '('){
                stack.push(sum);
                stack.push(sign);
                sign = 1 ;
                sum = 0 ;
            }else if (s.charAt(i) == ')'){
                int prevSign = stack.pop(); 
                int prevSum = stack.pop(); 
                int temp = prevSign * sum ;
                sum = temp + prevSum ;
            }else if (s.charAt(i) == '-'){
             sign = sign * -1 ;   
            }
         i++;
        }
        return sum ;
    }
}