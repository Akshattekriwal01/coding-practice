class Solution {
 
    public int[] dailyTemperatures(int[] temperatures) {
        int i = temperatures.length - 1 ;
        int[] arr = new int[temperatures.length] ; 
        Stack<Integer> stack = new Stack<Integer>();
        while(i >= 0){
          while(!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i] ){
              stack.pop(); 
          }  
            if(stack.isEmpty()) 
                arr[i] = 0; 
            else arr[i] = stack.peek() - i;
            stack.push(i);
            i-- ;
        }
       return arr ; 
    }
}